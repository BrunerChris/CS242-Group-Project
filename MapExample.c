//Nicholas Gapp

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>

//linked list for reference list
struct node {
  char *establishment;
  struct map *ptr;
  struct node *next;
};

//linked list for map
struct map {
  char *business;
  struct map *links[10];
  int cost[10];
  int NumLinks;
};

double timer();

int main()
{
  int LOOP, COST = 0;;
  double time_st = 0, time_end = 0;
  char START[42], END[42];
  time_st = timer();


  for(LOOP=0; LOOP<=46000; LOOP++)
  {
    FILE *infile;
    char *line = NULL, *start = NULL, *place, *end = NULL, *foo = NULL;
    struct map *aptr = NULL, *bptr;
    struct node *places, *phead = NULL, *NewNode = NULL, *Home = NULL, *Start = NULL;
    size_t len = 0;
    ssize_t read;
    int i = 0, weight = 0, r = 0;

    infile = fopen("hw9.data", "r");

    //Reading file until first STOP and creating indexing linked list
    while((read = getline(&line, &len, infile)) != -1)
    {
      if(strcmp(line, "STOP\n") == 0)
        break;

      places = (struct node *)malloc(sizeof(struct node));

      place = strtok(line, "\n");
      places->establishment = malloc(strlen(place) * sizeof(char));
      strcpy(places->establishment, place);

      if(!phead)
      {
        places->next = phead;
        phead = places;
      }
      else
      {
        NewNode = phead;
        while(NewNode->next)
          NewNode = NewNode->next;

        NewNode->next = places;
        places->next = NULL;
      }
    }

    //Reading file until second STOP and creating map
    places = phead;
    line = NULL;
    while((read = getline(&line, &len, infile)) != -1)
    {
      if(strcmp(line, "STOP STOP 0\n") == 0)
        break;

      start = strtok(line, " ");

      if(aptr == NULL)
      {
        aptr = (struct map *)malloc(sizeof(struct map));
        places->ptr = aptr;
        aptr->business = malloc(strlen(start) * sizeof(char));
        strcpy(aptr->business, start);
      }

      if(strcmp(places->establishment, start) == 0)
      {
        bptr = (struct map *)malloc(sizeof(struct map));

        end = strtok(NULL, " ");
        bptr->business = malloc(strlen(end) * sizeof(char));
        strcpy(bptr->business, end);

        foo = strtok(NULL, "\n");
        weight = atoi(foo);
        bptr->cost[i] = weight;

        aptr->links[i] = bptr;
        i++;
      }
      else
      {
        places = places->next;

        aptr->NumLinks = i;

        if(strcmp(start, "Deadend") == 0)
          continue;

        aptr = (struct map *)malloc(sizeof(struct map));
        places->ptr = aptr;
        aptr->business = malloc(strlen(start) * sizeof(char));
        strcpy(aptr->business, start);

        i=0;
        bptr = (struct map *)malloc(sizeof(struct map));

        end = strtok(NULL, " ");
        bptr->business = malloc(strlen(end) * sizeof(char));
        strcpy(bptr->business, end);

        foo = strtok(NULL, "\n");
        weight = atoi(foo);
        bptr->cost[i] = weight;

        aptr->links[i] = bptr;
        i++;
      }
    }

    //Read in start point.
    line = NULL;
    read = getline(&line, &len, infile);
    start = strtok(line, "\n");

    //Drinking heavily until fully torqued
    srand(1234567);
    r = rand() % 10;

    //Finding Start and Home nodes
    places = phead;
    while(places)
    {
      if(strcmp(start, places->establishment) == 0)
        Start = places;

      if(strcmp(places->establishment, "Home") == 0)
        Home = places;

      places = places->next;
    }

    //Finding next random place and subsequent node
    place = NULL;
    weight = 0;
    NewNode = NULL;
    while(1)
    {
      if(r < Start->ptr->NumLinks)
      {
        place = Start->ptr->links[r]->business;
        break;
      }
      else
        r = rand() % 10;
    }

    places = phead;
    while(places)
    {
      if(strcmp(places->establishment, place) == 0)
        NewNode = places;

      places = places->next;
    }

    r = rand() % 10;
    
    //Taking a drunk walk.  Counts costs of places visited along the way
    while(1)
    {
      if(strcmp(NewNode->ptr->business, Home->ptr->business) != 0)
      {
        if(r < NewNode->ptr->NumLinks)
        {
          weight += NewNode->ptr->links[r]->cost[r];
          place = NewNode->ptr->links[r]->business;
          places = phead;
          while(places)
          {
            if(strcmp(place, places->establishment) == 0)
              NewNode = places;

            places = places->next;
          }

          r = rand() % 10;
        }
        else
        {
          r = rand() % 10;
          continue;
        }
      }
      else
      {
        if(LOOP == 0)
        {
          COST = weight;
          strcpy(START, Start->establishment);
          strcpy(END, Home->establishment);
        }
        break;
      }
    }

    //Freeing memory
    places = phead;
    NewNode = NULL;
    free(line);
    while(places)
    {
      NewNode = places->next;
      free(places->establishment);
      free(places->ptr->business);
      for(i=0; i<places->ptr->NumLinks; i++)
        free(places->ptr->links[i]);
      free(places->ptr);
      free(places);
      places = NewNode;
    }

    fclose(infile);
  } //end timer loop

  printf("You found your way home!\n");
  printf("...it only cost %d for you to get from %s to %s\n", COST, START, END);

  time_end = timer();
  printf("\n%lf seconds\n", time_end - time_st);

  return 0;
}

double timer()
{
  struct timeval tp;
  struct timezone tzp;

  int i;
  i = gettimeofday(&tp, &tzp);

  return ((double) tp.tv_sec + (double) tp.tv_usec * 1e-6);
}
