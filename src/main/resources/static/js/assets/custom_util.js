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

