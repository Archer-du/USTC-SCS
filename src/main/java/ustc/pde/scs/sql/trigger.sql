use scs;

CREATE TRIGGER afterChooseCourse
    AFTER INSERT ON selectcourse
    FOR EACH ROW
BEGIN
    UPDATE course
    SET selectedNum = IF(selectedNum < (SELECT maxNum FROM course WHERE courseId = NEW.courseId),
                         selectedNum + 1, selectedNum)
    WHERE courseId = NEW.courseId;
END;

CREATE TRIGGER afterCancelCourse
    AFTER DELETE ON selectcourse
    FOR EACH ROW
BEGIN
    UPDATE course
    SET selectedNum = IF(selectedNum > 0,
                         selectedNum - 1, selectedNum)
    WHERE courseId = OLD.courseId;
END;
