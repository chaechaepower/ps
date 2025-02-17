-- 코드를 작성해주세요


--  Python 또는 C#에 해당하는 코드랑 각각 & 연산했을 때 그 코드가 나오면 있는 거



SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT CODE
                    FROM SKILLCODES B
                    WHERE NAME='C#')
OR SKILL_CODE & (SELECT CODE
                    FROM SKILLCODES B
                    WHERE NAME='Python')
ORDER BY ID