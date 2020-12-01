function sortingTwoElements(elements, fromPosition, toPosition) {
    var temp = elements[fromPosition];
    elements[fromPosition] = elements[toPosition];
    elements[toPosition] = temp;
}

function isSortingRequired(fromElement, toElement) {
    return fromElement > toElement;
}

function bubbleSort(elements) {
    for (let i = 0; i < elements.length; i++) {
        var position = 0;
        for (let j = 1; j < elements.length; j++) {
            if (isSortingRequired(elements[position], elements[j])) {
                sortingTwoElements(elements, position, j)
            }
            position = j;
        }
    }
    return elements;
}

function printingTheElements(elements) {
    for (let index = 0; index < elements.length; index++) {
        console.log(elements[index]);
    }
}

var elementsNeedToSort = [5, 1, 4, 2, 8]
var elementsSort = bubbleSort(elementsNeedToSort)
printingTheElements(elementsSort)
