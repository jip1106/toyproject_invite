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
        displayRetry();

    });


    $(".save_btn > li > a.save").on("click", function(){
        let saveObj = {};
        let optionIds = [];
        let priorities = [];

        $.each(curSelectedOptions, (index, item) => {
            optionIds.push($(item).attr("data-id"));
            priorities.push(index);
        });

        saveObj = {
            optionIds : optionIds,
            priorities : priorities
        };

        //옵션 저장
        saveSelectedOptions(saveObj);

    });

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

//sortable.js 오류로 잘못 생성되는경우
const displayRetry = () => {

    resetCurSelectedOptions();

    $.each( $("#selectedItem > li"), function(index, item){
        curSelectedOptions.push(item);
    });

    displayCurSelectedOptions();
}



//옵션 세팅
async function setBaseOptions(inviteType){
    const ulArea = document.querySelector('.option > ul#baseItem');
    ulArea.querySelectorAll('li').forEach( li => li.remove());

    const baseOptions =
        await getBaseOptions(inviteType).then(
            (res) => {
                console.log(res);
                let addHtml = ``;
                res.forEach( (baseOption) => {
                    addHtml +=
                        `
                            <div class="balloon none">${baseOption.description}</div>
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

//Sortable.js 세팅 st
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
        onStart: function(evt){
            $(evt.item).prev().removeClass("none");
        },
        onEnd: function(evt){

            if($(".sortable-item").hasClass('sortable-selected')){
                $(".sortable-item").removeClass('sortable-selected');
            }

            $(".balloon").addClass("none");

            resetCurSelectedOptions();

            evt.to.querySelectorAll("li").forEach((item, index) => {
                let pushData = true;
                curSelectedOptions.forEach((li) => {

                    if(item.dataset.dup == "false" && li.dataset.id.includes(item.dataset.id)){
                        alert(`${item.innerText}(은)는 중복 가능한 옵션이 아닙니다.`);
                        li.remove();
                        pushData = false;
                        //curSelectedOptions.pop();
                        return;
                    }

//
//                    if(li.dataset.id == item.dataset.id){
//                        item.dataset.id = item.dataset.id + "_" + index;
//                    }
                })

                if(pushData){
                    curSelectedOptions.push(item);
                }


            });

            displayRetry();


        },
        onSelect: function(evt){
            $(evt.item).prev().removeClass("none");
        },
        onDeselect: function(evt){
            $(evt.item).prev().addClass("none");
        },


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
        onEnd: function(evt){

            displayRetry();

        }
    });
}
// Sortable.js end


async function saveSelectedOptions(saveObj){

    addSltOptions(saveObj).then(
        (response) => {
            //옵션저장 성공
            console.log(response);
        },
        (errorResponse) => {
            //옵션 저장 실패
            console.log(errorResponse);

        }
    );

}




