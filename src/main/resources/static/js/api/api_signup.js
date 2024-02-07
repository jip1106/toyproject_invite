
//회원 id 중복 확인
async function dupCheck(paramMemberId){
    const memberId = paramMemberId;
    const apiUrl = '/api/user/idcheck/' + memberId;

    return await $.ajax({
        url : apiUrl,
        type: 'GET'
    });
};


//회원 가입
function addMember(requestData){
    const apiUrl = '/api/user/signup';

    return $.ajax({
        url : apiUrl,
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(requestData)
    });
};


//회원정보 조회
async function getMemberDetail(memberSeq, memberId){
    const apiUrl = '/api/user/' + memberSeq + "/" + memberId

    return await $.ajax({
        url : apiUrl,
        type : 'GET'
    });
};

//로그인
function doLogin(requestData){
    const apiUrl = '/api/user/login';

    return $.ajax({
        url : apiUrl,
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(requestData)
    });
};