/**
    회원 중복 확인
*/
async function dupApiCheckApi(paramMemberId){
    const memberId = paramMemberId;
    const apiUrl = '/user/idcheck/' + memberId;

    return await $.ajax({
        url : apiUrl,
        type: 'GET'
    });
};