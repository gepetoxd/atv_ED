#include <stdlib.h>
#include <stdio.h>

typedef struct element {
    char value;
    struct element *next;
    struct element *prev; 
} Element;

typedef struct list {
    Element* head;
    Element* tail;
    int size;
} List;
List* start() {
    List *l = (List*)malloc(sizeof(List));
    l->head = NULL;
    l->tail = NULL;
    l->size = 0;
    return l;
}
int empty(List* l) {
    return l->size == 0;
}

int size(List* l) {
    return l->size;
}
void add(List *l, char character) {
    Element* e = malloc(sizeof(Element));
    e->value = character;
    e->prev = NULL;

    if (empty(l)) {
        e->next = NULL;
        l->head = e;
        l->tail = e;
    } else {
        e->next = l->head;
        l->head->prev = e;
        l->head = e;
    }

    l->size++;
}
void add_pos(List *l, char character, int position) {
    if (position < 1 || position > l->size + 1) {
        printf("Invalid position!\n");
        return;
    }

    if (position == 1) {
        add(l, character);
        return;
    }

    if (position == l->size + 1) {
        Element* e = malloc(sizeof(Element));
        e->value = character;
        e->next = NULL;
        e->prev = l->tail;
        l->tail->next = e;
        l->tail = e;
        l->size++;
        return;
    }
    Element* current = l->head;
    for (int i = 1; i < position; i++) {
        current = current->next;
    }

    Element* e = malloc(sizeof(Element));
    e->value = character;

    e->next = current;
    e->prev = current->prev;

    current->prev->next = e;
    current->prev = e;

    l->size++;
}
char get(List *l, int position) {
    if (empty(l)) return '\0';
    if (position < 1 || position > l->size) return '\0';

    Element* e = l->head;
    for (int i = 1; i < position; i++) {
        e = e->next;
    }

    return e->value;
}

void set(List *l, int position, char character) {
    if (empty(l)) return;
    if (position < 1 || position > l->size) return;

    Element* e = l->head;

    for (int i = 1; i < position; i++) {
        e = e->next;
    }

    e->value = character;
}
char delete(List *l, int position) {
    if (empty(l)) {
        printf("Empty list!\n");
        return '\0';
    }

    if (position < 1 || position > l->size) {
        printf("Invalid position!\n");
        return '\0';
    }

    Element* removed;

    if (position == 1) {
        removed = l->head;
        char value = removed->value;

        l->head = removed->next;

        if (l->head != NULL)
            l->head->prev = NULL;
        else
            l->tail = NULL; 

        free(removed);
        l->size--;
        return value;
    }
    if (position == l->size) {
        removed = l->tail;
        char value = removed->value;

        l->tail = removed->prev;
        l->tail->next = NULL;

        free(removed);
        l->size--;
        return value;
    }
    removed = l->head;
    for (int i = 1; i < position; i++) {
        removed = removed->next;
    }

    char value = removed->value;

    removed->prev->next = removed->next;
    removed->next->prev = removed->prev;

    free(removed);
    l->size--;
    return value;
}
void print(List *l) {
    if (empty(l)) {
        printf("Empty list!\n");
        return;
    }

    Element* e = l->head;
    printf("Lista (size: %d):\n", l->size);

    while (e != NULL) {
        printf("[%c] <-> ", e->value);
        e = e->next;
    }

    printf("NULL\n");
}
void destroy(List *l) {
    Element* current = l->head;
    Element* next;

    while (current != NULL) {
        next = current->next;
        free(current);
        current = next;
    }

    free(l);
}
int main() {
    List *l = start();

    add(l, '@');
    add(l, '#');
    add(l, '$');
    add(l, '%');

    print(l);

    set(l, 4, '*');
    print(l);

    printf("Elemento na posição 3: %c\n", get(l, 3));

    destroy(l);

    return 0;
}
