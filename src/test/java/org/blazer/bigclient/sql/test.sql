/*
b.start_date <= dateStart
b.end_date >= dateEnd  有可能为null
a.phone_number like %phoneNumber%
*/

SELECT
a.id(b.user_id),
a.phone_number,
a.report_or_allot,
a.report_or_allot_date,
a.user_identify,
a.investment_adviser(c.actual_name),
a.if_delete,
a.mtime,
a.ctime
FROM
cl_formal_user AS a;

SELECT
b.id,
b.user_id,
b.advisor_id(c.id),
b.version_no,
b.start_date,
b.end_date,
b.mtime,
b.ctime
FROM
cl_formal_user_version AS b;

SELECT
c.id,
c.tid,
c.serial_number,
c.level,
c.system_name,
c.actual_name,
c.phone_number,
c.remark,
c.mtime,
c.ctime
FROM
kam_advisor AS c;