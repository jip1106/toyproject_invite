async function getBaseOptions(inviteType){
    const apiUrl = '/api/option/' + inviteType;

    return await $.ajax({
        url : apiUrl,
        type: 'GET'
    });
};