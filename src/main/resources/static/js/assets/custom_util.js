/*
    공통함수 정의
*/

//숫자 세자리 콤마
const joinComma = (num) => {
  if (!num) {
    return '0';
  }
  return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
};

const padZero = (num) => {
    return num < 10 ? '0' + num : num;
}

// 날짜를 원하는 형식으로 포맷하는 함수
const getFormattedDate = (date, type) => {
    let year = date.getFullYear();
    let month = padZero(date.getMonth() + 1);
    let day = padZero(date.getDate());
    return year + type + month + type + day;
}


//null 체크 null인 경우 return false null이 아닌경우 return true;
const isNotNull = (value) => {

    if (typeof value === 'string') {
        value = value.trim();
    }

    if(value === null ||  value === undefined || value === ''){
        return false;
    }else{
        return true;
    }
}

//null 체크 null인 경우 return true null이 아닌경우 return false;
const isNull = (value) => {
    return !isNotNull(value);
}


//로그아웃
const doLogout = () => {
    const apiUrl = '/api/logout';
    $.ajax({
        url : apiUrl,
        type : 'POST'
    })
    .then(
        (res) => {
            location.href="/";
        },
        (err) => {
            console.log(err);
        }
    );
};

//숫자,영어만 입력
const onlyNumAndAlphabet = (value) => {
    const regex = /^[a-zA-Z0-9]+$/;
    return regex.test(value);
}
//숫자만 입력
const onlyNum= (value) => {
    const regex = /^[0-9]+$/;
    return regex.test(value);
}
