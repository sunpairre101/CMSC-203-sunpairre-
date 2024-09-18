#include <iostream>
#include <iomanip>
using namespace std;

void displayArray(int array[], int size);
void selectionSort(int array[], int size);
int findMax(int array[], int size);
int findMin(int array[], int size);
double findAvg(int array[], int size);

int main() {
    const int max = 50;
    int size;
    int data[max];

    cout << "Enter the number of scores: " ;
    cin >> size;

    if (size <= 0 || size > max) {
        cout << "Invalid size. Please enter a number between 1 and " << max << "." << endl;
        return 1;
    }

    for (int i = 0; i < size; i++) {
        cout << "Score [" << (i + 1) << "]: ";
        cin >> data[i];
    }


    cout << "Original Order scores:";
    displayArray(data, size);

    cout << "Scores ordered from high to low:";
    selectionSort(data, size);
    displayArray(data, size);

    cout << "Highest score: " << findMax(data, size) << endl;
    cout << "Lowest score: " << findMin(data, size) << endl;
    cout << "Average of scores: " << findAvg(data, size) << endl;

    return 0;
}

void displayArray(int array[], int size) {
    for (int i = 0; i < size; i++) {
        cout << setw(4) << array[i];
    }
    cout << endl;
}

void selectionSort(int array[], int size) {
    for (int i = 0; i < size - 1; i++) {
        int maxIndex = i;
        for (int j = i + 1; j < size; j++) {
            if (array[j] > array[maxIndex]) {
                maxIndex = j;
            }
        }
        if (maxIndex != i) {
            swap(array[i], array[maxIndex]);
        }
    }
}

int findMax(int array[], int size) {
    int maxScore = array[0];
    for (int i = 1; i < size; i++) {
        if (array[i] > maxScore) {
            maxScore = array[i];
        }
    }
    return maxScore;
}

int findMin(int array[], int size) {
    int minScore = array[0];
    for (int i = 1; i < size; i++) {
        if (array[i] < minScore) {
            minScore = array[i];
        }
    }
    return minScore;
}

double findAvg(int array[], int size) {
    if (size == 0) {
        return 0.0; \
    }
    int total = 0;
    for (int i = 0; i < size; i++) {
        total += array[i];
    }
    return static_cast<double>(total) / size;
}
