async function getBaseOptions(inviteType){
    const apiUrl = '/api/option/' + inviteType;

    return await $.ajax({
        url : apiUrl,
        type: 'GET'
    });
};


//옵션 저장
function addSltOptions(requestData){
    const apiUrl = '/api/option/saveSltOptions';

    console.log(requestData);

    return $.ajax({
        url : apiUrl,
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(requestData)
    });
};