package ru.epam.javacore.lesson_24_db_web.homework.reporting;

import ru.epam.javacore.lesson_24_db_web.homework.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
