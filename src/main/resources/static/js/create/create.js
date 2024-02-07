$(function(){
    init();

    $("input[name='inviteType']").on("change",function(){
        const inviteType = $(this).val();
        setBaseOptions(inviteType);
    });

});

function init(){
    setBaseOptions("DEFAULT");
    sortInit(); //Sortable.js 동작
}


async function setBaseOptions(inviteType){
    const ulArea = document.querySelector('.option > ul#baseItem');
    ulArea.querySelectorAll('li').forEach( li => li.remove());

    const baseOptions =
        await getBaseOptions(inviteType).then(
            (res) => {
                let addHtml = ``;
                res.forEach( (baseOption) => {
                    addHtml +=
                        `
                            <li data-id="${baseOption.code}">${baseOption.name}</li>
                        `;
                })

                ulArea.innerHTML += addHtml;

            },
            (err) => {

                console.log(err);

            }
        )
        ;

}


function sortInit(){
    //기본 제공 옵션들
    let el = document.getElementById('baseItem');

    new Sortable(el,{
        group: 'shared', // A 영역과 B 영역을 같은 그룹으로 설정하여 서로 연결
        sort: false, // A 영역의 순서를 변경할 수 없도록 설정
        pull: 'clone', // 이동시 데이터를 복제하여 이동
        animation: 150, // 드래그 애니메이션 지속 시간
        multiDrag: true, // Enable multi-drag
        selectedClass: 'sortable-selected', // The class applied to the selected items
        /*
        onSelect: function(evt){
            console.log(evt.item);
        },

        onDeselect: function(evt){
            console.log(evt.item);
        }
    */
    });

    //선택된 항목들
    el = document.getElementById('selectedItem');

    new Sortable(el,{
        group: 'shared', // A 영역과 B 영역을 같은 그룹으로 설정하여 서로 연결
        sort: true, // B 영역의 순서를 변경할 수 있도록 설정
        onMove: function (evt) {

            if (evt.to.getAttribute("id") === 'baseItem') { // baseItem 영역으로 이동X
                console.log("aa");
                evt.returnToSender = false;
                return false;
            }
        },
        animation: 150 // 드래그 애니메이션 지속 시간

    });

}


