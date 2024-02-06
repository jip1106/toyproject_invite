$(function(){
    sortInit();

});


function sortInit(){
    //기본 제공 옵션들
    let el = document.getElementById('baseItem');

    new Sortable(el,{
        group: {
            name: 'shared',
            pull: 'clone' // To clone: set pull to 'clone'
        },
        ghostClass: 'bgc_yellow',
        multiDrag: true, // Enable multi-drag
        selectedClass: 'bgc_yellow', // The class applied to the selected items
        fallbackTolerance: 3, // So that we can select items on mobile
        animation: 150


    });

    //선택된 항목들
    el = document.getElementById('selectedItem');

    new Sortable(el,{
         group: {
            name: 'shared',
            pull: 'clone' // To clone: set pull to 'clone'
        },
        animation:150,
        ghostClass: 'bgc_yellow'

    });

}


