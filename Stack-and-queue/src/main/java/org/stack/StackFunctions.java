package org.stack;

public class StackFunctions {
    private StackFunctions() {
    }

    /**
     * Napisz funkcję StosL, która z ciągu liczb naturalnych o długości M wybierze liczby, które są
     * wielokrotnością pewnej liczby naturalnej l>0 i odłoży te liczby na stos. Przyjmij dla stosu
     * implementację wskaźnikową. Zdefiniuj wszystkie użyte funkcje i struktury danych oraz
     * zmienne,
     *
     * @param sequenceOfNumbers
     * @param l
     */
    public static Stack<Integer> stosL(int[] sequenceOfNumbers, int l) {
        Stack<Integer> stack = new PointerStack();
        for (int n : sequenceOfNumbers) {
            if (n % l == 0) {
                stack.push(n);
            }
        }
        return stack;
    }

    /**
     * Napisz funkcję, która obróci zawartość stosu:
     * a. Przy użyciu drugiego stosu,
     *
     * @param stack
     * @return
     */
    public static Stack<Integer> reverseStackMethodA(Stack<Integer> stack) {
        Stack<Integer> result = new PointerStack();
        while (!stack.empty()) {
            result.push(stack.pop());
        }
        return result;
    }

    /**
     * Napisz funkcję, która obróci zawartość stosu:
     * b. Bez użycia dodatkowych struktur danych.
     *
     * @param stack
     * @return
     */
    public static Stack<Integer> reverseStackMethodB(Stack<Integer> stack) {
        return stack.reverse();
    }

    /**
     * 3. Napisz funkcję, która ze stosu usunie element znajdujący się na pozycji n (licząc od
     * wierzchołka stosu). Dla stosu przyjmij implementację tablicową. Zdefiniuj wszystkie użyte
     * struktury danych, operacje i zmienne,
     *
     * @param stack
     * @param elementIndex
     * @return
     */
    public static Integer removeElementFromStackArrayImpl(ArrayStack stack, int elementIndex) {
        return stack.remove(elementIndex);
    }

    /**
     * Połącz dwie listy (implementacja wskaźnikowa) w następujący sposób: el_listy1, el_listy2,
     * el_listy1, el_listy2, itd. Wynik połączenia powinien znajdować się w liście pierwszej. Lista
     * druga po zakończeniu łączenia powinna być pusta. Jeśli druga lista okaże się dłuższa niż
     * pierwsza, dołącz pozostałe elementy listy drugiej na koniec listy pierwszej. Zdefiniuj wszystkie
     * użyte struktury danych, operacje i zmienne
     * @param list1
     * @param list2
     */
    public static void mergeTwoLists(CustomLinkedList list1, CustomLinkedList list2){
        list1.merge(list2);
    }

    /**
     * Napisz funkcję UsuńX, która z kolejki prostej usunie element o wartości x, jeśli taki element w
     * kolejce się znajduje. Dla kolejki przyjmij implementację tablicową. Zdefiniuj wszystkie użyte
     * funkcje i struktury danych oraz zmienne.
     *
     * @param queue
     * @param value
     * @return
     */
    public static boolean removeElementFromQueue(Queue queue, int value) {
        int index = queue.indexOf(value);
        if (index != -1) {
            queue.remove(index);
            return true;
        }
        return false;
    }
}
