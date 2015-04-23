#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


struct Node {
  int data;
  struct Node *next;
};

void printNode(struct Node *n) {
  printf("data=%d next=0x%x", n->data, (int)n->next);
}

void removeDuplicates(struct Node *n) {
  struct Node *prev;
  struct Node *runner;

  bool debug = false;

  prev = n;
  while (n != NULL) {        
    runner = n->next; // check for duplicates of n.data with reset of linked list

    if (debug) {
      printf("current node=");
      printNode(n);
      printf("\n");
    }
    
    while (runner != NULL) {
      if (debug) {
      	printf("runner node=");
      	printNode(runner);
      	printf("\n");
      }
      
      if (runner->data == n->data) {
	// delete runner node from linked list (delete link to current node and instead connect it to next node)
	prev->next = runner->next;
	prev = runner->next;
	if (debug) {printf("deleted duplicate node\n");}
      } else {
	prev = runner;
	if (debug) {printf("advanced normally\n");}
      }      
      runner = runner->next; // check next node in linked list      
    }
    n = n->next; // check for duplicates comparing the rest of the linked list with next node
  }
}


void printTraverseLinkedList(struct Node *n) {
  while (n != NULL) {
    printNode(n);
    printf("\n");
    n = n->next;
  }
}


int main (void) {  

  struct Node *nodeArr[10];

  for (int i=0; i<10; i++) {
    nodeArr[i] = (struct Node *) malloc(sizeof(struct Node));
  }
  for (int i=0; i<9; i++) {
    nodeArr[i]->data = i+1;
    nodeArr[i]->next = nodeArr[i+1];
  }
  nodeArr[9]->data = 9+1;
  nodeArr[9]->next = NULL;

  nodeArr[4]->data = 8;
  nodeArr[0]->data = 3;  

  printf("\n\nBefore removing duplicates\n");
  printTraverseLinkedList(nodeArr[0]);

  removeDuplicates(nodeArr[0]);

  printf("\n\nAfter removing duplicates\n");
  printTraverseLinkedList(nodeArr[0]);
  
  return EXIT_SUCCESS;
}
