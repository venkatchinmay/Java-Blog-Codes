function isSortingRequired(elementFromLowerIndex, elementFromHeigherIndex) {
    return elementFromLowerIndex > elementFromHeigherIndex
}

function swappingElements(elements, fromIndex, toIndex) {
    var temp = elements[fromIndex]
    elements[fromIndex] = elements[toIndex]
    elements[toIndex] = temp
}

function selectionSort(elements) {
    for (var i = 0; i < elements.length; i++) {
        var position = i;
        for (var j = position + 1; j < elements.length; j++) {
            if (isSortingRequired(elements[position], elements[j])) {
                position = j;
            }
        }
        swappingElements(elements, i, position)
    }
    return elements;
}

function printOutElements(elements) {
    elements.forEach(element => {
        console.log(element)
    });
}

var elementsNeedToSort = [5, 1, 4, 2, 8]
var elementsSort = selectionSort(elementsNeedToSort)
printOutElements(elementsSort)

