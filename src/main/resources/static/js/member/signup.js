$(function(){

    //회원가입 중복체크 버튼 클릭
    $("#dupChcek").on("click",function(){
        const memberId = $("#memberId").val();
        const apiUrl = '/user/idcheck/' + memberId;

        // AJAX 요청 보내기
        fetch(apiUrl, {
            method: 'GET', // 요청 메서드 설정 (GET, POST 등)
            headers: {
                'Content-Type': 'application/json' // 요청 데이터 형식 설정 (JSON)
            },
            //body: JSON.stringify(sendData) // 데이터를 JSON 문자열로 변환하여 요청 본문에 포함
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // JSON 형식의 응답 데이터 파싱
        })
        .then(data => {
            // 성공적으로 데이터를 전송하고 응답을 받았을 때 실행할 코드 작성
            console.log('Response from server:', data);
            if(data > 0 ){
                alert("중복된 아이디 입니다.");
                return false;
            }else{
                alert("가입할 수 있습니다.");
                return false;
            }
        })
        .catch(error => {
            // 요청이 실패하거나 오류가 발생했을 때 실행할 코드 작성
            console.error('There was a problem with your fetch operation:', error);
        });

    });


});
