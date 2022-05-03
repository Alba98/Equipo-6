FUNCTION  BUSCAR_PERSONA_POR_NICKNAME
    (P_NICKNAME VARCHAR2)
    RETURN NUMBER
    AS
        P_NUM_PERSONA PERSONA.NICKNAME%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_PERSONA INTO P_NUM_PERSONA
        FROM PERSONA
        WHERE UPPER(NICKNAME) = UPPER(P_NICKNAME);
        -- devolver el codigo de la persona
        RETURN P_NUM_PERSONA;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        P_NUM_PERSONA:=NULL;
         RAISE_APPLICATION_ERROR (-20001 ,'Err. nickname no encontrado');
        RETURN P_NUM_PERSONA;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        P_NUM_PERSONA:=-1;
        RETURN P_NUM_PERSONA;
END BUSCAR_PERSONA_POR_NICKNAME;