let curSelectedOptions = [];
let deletedOptions = [];

$(function(){
    init();

    //타입 선택
    $("input[name='inviteType']").on("change",function(){
        const inviteType = $(this).val();
        setBaseOptions(inviteType);
    });

    //선택한 옵션 삭제 (선택삭제 버튼 클릭)
    $(".ul_btn > li > a.sel_del").on("click",function(){
         deletedOptions.forEach((item, index) => {

            let ele = $("#selectedItem > li").get();

            $.each(ele, function(index, li){

                if($(li).attr("data-id") == $(item).attr("data-id")){
                    $(li).remove();
                }
            });


            ele = $(".box > p > span").get();
            $.each(ele, function(index, span){

                if($(span).attr("data-id") == $(item).attr("data-id")){
                    $(span).remove();
                }
            });

            curSelectedOptions =
                    curSelectedOptions.filter((cur) => cur.dataset.id != item.dataset.id);

        });


        resetDeletedOptions();
    });

    //전체 선택한 옵션 삭제 (초기화 버튼 클릭)
    $(".ul_btn > li > a.del").on("click",function(){

        $("#selectedItem > li").remove();


        resetDeletedOptions();
        resetCurSelectedOptions();

        displayCurSelectedOptions();

    });


    $(".save_btn > li > a.save").on("click", function(){
        alert("a");
    })

});

const init = () =>{
    setBaseOptions("DEFAULT");  //옵션 세팅

    sortInit(); //Sortable.js 동작
}

const resetDeletedOptions = () => {
    deletedOptions.length = 0;

    if(curSelectedOptions.length == 0){
        $(".actions.small.save_btn").addClass("none");
    }
}

const resetCurSelectedOptions = () =>{
    curSelectedOptions.length = 0;
    $(".actions.small.save_btn").addClass("none");
}

const displayCurSelectedOptions = () => {

    $('.box > p').empty();

    curSelectedOptions.forEach(item => {
        let addHtml = ``;

        let data_id = item.getAttribute("data-id");
        let data_dup = item.getAttribute("data-dup");
        addHtml += `
            <span data-id="${data_id}" data-dup = "${data_dup}"> ${item.innerText} </span>
        `;

        $('.box > p').append(addHtml);
    });

    if(curSelectedOptions.length > 0){
        $(".actions.small.save_btn").removeClass("none");
    }

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
                            <li class="sortable-item" data-id="${baseOption.code}" data-dup="${baseOption.dupCheck}">
                                ${baseOption.name}
                            </li>
                        `;
                })

                ulArea.innerHTML += addHtml;

            },
            (err) => {

                console.log(err);

            }
        );
}


function sortInit(){
    //BASE OPTION
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
        onEnd: function(evt){

            //console.log(movedItems);
            if($(".sortable-item").hasClass('sortable-selected')){
                $(".sortable-item").removeClass('sortable-selected');
            }

            resetCurSelectedOptions();

            evt.to.querySelectorAll("li").forEach((item, index) => {

                curSelectedOptions.forEach((li) => {

                    if(item.dataset.dup == "false" && li.dataset.id.includes(item.dataset.id)){
                        alert("중복 가능한 옵션이 아닙니다.");
                        li.remove();
                        curSelectedOptions.pop();
                        return;
                    }

                    if(li.dataset.id == item.dataset.id){
                        item.dataset.id = item.dataset.id + "_" + index;
                    }
                })

                 curSelectedOptions.push(item);

            })

            displayCurSelectedOptions();

        }

    });

    //SELECTED OPTION
    el = document.getElementById('selectedItem');

    new Sortable(el,{
        group: {
            name: 'shared', //  기본옵션 영역과 선택한 옵션 영역을 같은 그룹으로 설정하여 서로 연결
        },
        sort: true, // 선택한 옵션은 순서 조정 가능하도록
        onMove: function (evt) {
            if (evt.to.getAttribute("id") === 'baseItem') { // baseItem 영역으로 이동 못하도록
                return false;
            }
        },
        animation: 150, // 드래그 애니메이션 지속 시간
        multiDrag: true, // Enable multi-drag
        selectedClass: 'sortable-selected', // The class applied to the selected items

        onSelect: function(evt){
            //console.log(evt);
            deletedOptions = [...evt.items];

        },

        onDeselect: function(evt){

            //선택삭제 버튼을 눌렀을때 onDeselect 이벤트 안타도록 수정
            if(evt.originalEvent instanceof MouseEvent){
                return false;
            }

            //사용자가 직접 해제
            if(evt.originalEvent instanceof TouchEvent){
                deletedOptions = [...evt.items];
            }

        },
    });

}


