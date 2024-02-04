
//회원 id 중복 확인
async function dupApiCheckApi(paramMemberId){
    const memberId = paramMemberId;
    const apiUrl = '/api/user/idcheck/' + memberId;

    return await $.ajax({
        url : apiUrl,
        type: 'GET'
    });
};


//회원 가입