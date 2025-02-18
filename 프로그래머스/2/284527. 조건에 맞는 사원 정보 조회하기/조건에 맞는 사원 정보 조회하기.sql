-- 코드를 작성해주세요



-- 각 사원별 상,하반기 총점을 구한다
-- 그 중 가장 높은 점수를 가진 사원 id를 찾는다
-- select 한다.


WITH MAX_TOTAL AS (
    SELECT EMP_NO, SUM(SCORE) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
    ORDER BY SCORE DESC
    LIMIT 1
)

SELECT M.SCORE, H.EMP_NO, H.EMP_NAME, H.POSITION, H.EMAIL
FROM HR_EMPLOYEES H
    JOIN MAX_TOTAL M
    ON H.EMP_NO=M.EMP_NO


