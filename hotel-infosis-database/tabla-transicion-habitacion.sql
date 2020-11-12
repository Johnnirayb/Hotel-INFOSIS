--------------------------------------------------------
-- Archivo creado  - jueves-noviembre-12-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRUEBA_TRANSICION
--------------------------------------------------------

  CREATE TABLE "TESTPERU"."PRUEBA_TRANSICION" 
   (	"ID" NUMBER, 
	"ORIGEN" NUMBER, 
	"DESTINO" NUMBER, 
	"STATUS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DAT01_PERU" ;
REM INSERTING into TESTPERU.PRUEBA_TRANSICION
SET DEFINE OFF;
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('1','1','2','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('2','1','3','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('3','2','3','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('4','2','4','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('5','3','1','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('6','3','4','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('7','4','1','1');
Insert into TESTPERU.PRUEBA_TRANSICION (ID,ORIGEN,DESTINO,STATUS) values ('8','4','3','1');
--------------------------------------------------------
--  DDL for Index PRUEBA_TRANSICION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTPERU"."PRUEBA_TRANSICION_PK" ON "TESTPERU"."PRUEBA_TRANSICION" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DAT01_PERU" ;
--------------------------------------------------------
--  Constraints for Table PRUEBA_TRANSICION
--------------------------------------------------------

  ALTER TABLE "TESTPERU"."PRUEBA_TRANSICION" ADD CONSTRAINT "PRUEBA_TRANSICION_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "DAT01_PERU"  ENABLE;
  ALTER TABLE "TESTPERU"."PRUEBA_TRANSICION" MODIFY ("ID" NOT NULL ENABLE);
