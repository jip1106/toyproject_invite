let curSelectedOptions = [];

$(function(){
    init();

    //타입 선택
    $("input[name='inviteType']").on("change",function(){
        const inviteType = $(this).val();
        setBaseOptions(inviteType);
    });

    //선택한 옵션 삭제
    $(".ul_btn > li > a.sel_del").on("click",function(){
        console.log($(this));
    });

    //전체 선택한 옵션 삭제
    $(".ul_btn > li > a.del").on("click",function(){
        console.log($(this));
        $("#selectedItem > li").remove();
    });

});

function init(){
    setBaseOptions("DEFAULT");  //옵션 세팅
    sortInit(); //Sortable.js 동작
}

//옵션 세팅
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
        group: {
            name: 'shared', //  기본옵션 영역과 선택한 옵션 영역을 같은 그룹으로 설정하여 서로 연결
            pull: 'clone', // 이동시 데이터를 복제하여 이동
        },
        sort: false, // 기본옵션 영역의 순서를 변경할 수 없도록 설정
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
        group: {
            name: 'shared', //  기본옵션 영역과 선택한 옵션 영역을 같은 그룹으로 설정하여 서로 연결
        },
        sort: true, // 선택한 옵션은 순서 조정 가능하도록
        onMove: function (evt) {
            if (evt.to.getAttribute("id") === 'baseItem') { // baseItem 영역으로 이동 못하도록
                evt.returnToSender = false;
                return false;
            }
        },
        animation: 150, // 드래그 애니메이션 지속 시간
        multiDrag: true, // Enable multi-drag
        selectedClass: 'sortable-selected', // The class applied to the selected items

        onSelect: function(evt){

            curSelectedOptions.push(evt.item.getAttribute("data-id"));

        },

        onDeselect: function(evt){
            console.log(evt.item);
            console.log(evt.item.getAttribute("data-id"));

            curSelectedOptions =
                curSelectedOptions.filter((data) => evt.item.getAttribute("data-id") != data);

            console.log(curSelectedOptions);
        }

    });

}


