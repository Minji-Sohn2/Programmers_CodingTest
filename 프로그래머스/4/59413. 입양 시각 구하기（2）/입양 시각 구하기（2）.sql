-- 코드를 입력하세요
SET @HOUR = -1;                                     # @HOUR : 시간대를 나타내는 변수
SELECT(@HOUR := @HOUR + 1) AS HOUR,                 # 시간대를 증가시키는 쿼리
    (SELECT COUNT(HOUR(DATETIME)) FROM ANIMAL_OUTS  # 현재 시간대에 해당하는 동물이 나간 횟수
    WHERE HOUR(DATETIME) = @HOUR) AS COUNT
FROM ANIMAL_OUTS
WHERE @HOUR < 23;                                   # 23 전까지 해야 +1 해서 23을 만들 수 있음
