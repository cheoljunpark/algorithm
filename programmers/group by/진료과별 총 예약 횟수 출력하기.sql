SELECT
    mcdp_cd AS '진료과코드',
    count(*) AS '5월예약건수'
FROM appointment
WHERE MONTH(apnt_ymd) = 5
GROUP BY mcdp_cd
ORDER BY `5월예약건수` ASC, `진료과코드` ASC;
# ORDER BY 5월예약건수 ASC, 진료과코드 ASC;
# ORDER BY count(*) ASC, mcdp_cd ASC;
# ORDER BY '5월예약건수' ASC, '진료과코드' ASC; # <-- 이건 안됌
