/*
    공통함수 정의
*/

const joinComma = (num) => {
  if (!num) {
    return '0';
  }
  return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
};