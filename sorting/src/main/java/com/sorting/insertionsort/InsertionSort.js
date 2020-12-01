function isSortingRequired(elementfromLowerIndex, elementFromHeigherIndex) {
    return elementfromLowerIndex > elementFromHeigherIndex
}

function swappingtheelements(elements, fromIndex, toIndex) {
    var temp = elements[fromIndex]
    elements[fromIndex] = elements[toIndex]
    elements[toIndex] = temp
}

function insertionSort(elements) {
    for (let i = 0; i < elements.length; i++) {
        var position = i
        for (let j = position; (j < (elements.length - 1) && j >= 0); j--) {
            if (isSortingRequired(elements[j], elements[j + 1])) {
                swappingtheelements(elements, j, j + 1)
            }
        }
    }
    return elements
}

function printOutElements(elements) {
    elements.forEach(element => {
        console.log(element)
    });
}

var elementsNeedToSort = [5, 1, 4, 8, 2]
var elementsSort = insertionSort(elementsNeedToSort)
printOutElements(elementsSort)
