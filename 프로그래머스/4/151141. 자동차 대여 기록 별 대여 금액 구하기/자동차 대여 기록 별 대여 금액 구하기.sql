SELECT H.HISTORY_ID,
       FLOOR(
       (DATEDIFF(H.END_DATE,H.START_DATE) + 1) * C.DAILY_FEE * 
       (1 - (
            CASE 
                WHEN (DATEDIFF(H.END_DATE,H.START_DATE) + 1) >= 90 
                THEN (
                    SELECT DISCOUNT_RATE
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                    WHERE CAR_TYPE = '트럭'
                    AND DURATION_TYPE = '90일 이상'
                )
                WHEN (DATEDIFF(H.END_DATE,H.START_DATE) + 1) >= 30 
                THEN (
                    SELECT DISCOUNT_RATE
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                    WHERE CAR_TYPE = '트럭'
                    AND DURATION_TYPE = '30일 이상'
                )
                WHEN (DATEDIFF(H.END_DATE,H.START_DATE) + 1) >= 7 
                THEN (
                    SELECT DISCOUNT_RATE
                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                    WHERE CAR_TYPE = '트럭'
                    AND DURATION_TYPE = '7일 이상'
                )
                ELSE 0
            END 
       ) / 100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC

