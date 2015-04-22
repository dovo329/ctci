/*#include <stdlib.h>
#include <stdio.h>


void reverse(char *str){
  
  if(str == NULL)
    return ;

  int length, i;
  char * rev;

  for(i=0;;i++)
    if(str[i] == '\0')
      break;
  length = i;

  if(length > 0){
    rev = malloc(length * sizeof(char));
    
    for(i=0; i<length; i++)
      rev[length-1-i] = str[i];

    for(i=0; i<length; i++)
      str[i] = rev[i];

    free(rev);
  }

}

int is_reverse(char *str, char *rev){
  if(str == NULL || rev == NULL)
    return 0;

  int length, i;

  for(i=0;;i++)
    if(str[i] == '\0')
      break;
  
  length = i;

  for(i=0;;i++)
    if(rev[i] == '\0'){
      if(i != length)
        return 0;
      break;
    }

  for(i=0; i<length; i++)
    if(str[i] != rev[length-1-i])
      return 0;

  return 1;
}

int main(){
  char str[20] = "abcdefg";
  char str_backup[20] = "abcdefg";
  char * null = NULL;

  reverse(str);
  if(is_reverse(str, str_backup))
    printf("reverse(str) passed\n");
  else
    printf("reverse(str) failed\n");

  reverse(null);
  if(null == NULL)
    printf("reversible(null) passed\n");
  else
    printf("reversible(null) failed\n");

  return EXIT_SUCCESS;
}*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

void reverse(char *str) {
  char *end = str;
  char tmp;
  if (str == NULL) {
    return;
    
  }
  else
  {
     while (*end != NULL) {
       end++;
     }
     end--; // back up to the char before the nil

     while (str < end) {
     	  tmp = *str;
     	  *str = *end;
     	  *end = tmp;
     	  str++;
     	  end--;
     }
  }
}


int main() {
  //char *origStr = "ipalindromei";
  char *origStr = "supercalifragilisticexpialidocious!";
  char *testStr = (char *) malloc(strlen(origStr)+1);
  printf("origStr==%s\n", origStr);
  printf("pre strcpy testStr==%s\n", testStr);
  strcpy(testStr, origStr);
  printf("post strcpy testStr==%s\n", testStr);
  reverse(testStr);
  printf("reverse(\"%s\")==%s\n", origStr, testStr);
  
  return EXIT_SUCCESS;
}
