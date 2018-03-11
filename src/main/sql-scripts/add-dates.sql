# add alter the database table to add a new column for "date_of_birth".
ALTER TABLE `hb_student_tracker`.`student` ADD COLUMN `date_of_birth` DATETIME NULL AFTER `last_name`;