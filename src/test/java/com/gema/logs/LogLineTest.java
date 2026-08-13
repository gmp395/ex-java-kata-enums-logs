package com.gema.logs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogLineTest {

    @Test
    void parseaNivelInfo() {
        LogLine logLine = new LogLine("[INF]: File deleted");
        assertEquals(LogLevel.INFO, logLine.getLogLevel());
    }

    @Test
    void parseaNivelTrace() {
        LogLine logLine = new LogLine("[TRC]: Trace message");
        assertEquals(LogLevel.TRACE, logLine.getLogLevel());
    }

    @Test
    void parseaNivelDebug() {
        LogLine logLine = new LogLine("[DBG]: Debug message");
        assertEquals(LogLevel.DEBUG, logLine.getLogLevel());
    }

    @Test
    void parseaNivelWarning() {
        LogLine logLine = new LogLine("[WRN]: Warning message");
        assertEquals(LogLevel.WARNING, logLine.getLogLevel());
    }

    @Test
    void parseaNivelError() {
        LogLine logLine = new LogLine("[ERR]: Error message");
        assertEquals(LogLevel.ERROR, logLine.getLogLevel());
    }

    @Test
    void parseaNivelFatal() {
        LogLine logLine = new LogLine("[FTL]: Fatal message");
        assertEquals(LogLevel.FATAL, logLine.getLogLevel());
    }

    @Test
    void parseaNivelDesconocidoComoUnknown() {
        LogLine logLine = new LogLine("[XYZ]: Overly specific, out of context message");
        assertEquals(LogLevel.UNKNOWN, logLine.getLogLevel());
    }

    @Test
    void convierteAFormatoCortoConNivelInfo() {
        LogLine logLine = new LogLine("[INF]: File deleted");
        assertEquals("4:File deleted", logLine.getOutputForShortLog());
    }

    @Test
    void convierteAFormatoCortoConNivelError() {
        LogLine logLine = new LogLine("[ERR]: Stack Overflow");
        assertEquals("6:Stack Overflow", logLine.getOutputForShortLog());
    }

    @Test
    void convierteAFormatoCortoConNivelDesconocido() {
        LogLine logLine = new LogLine("[XYZ]: Unknown level message");
        assertEquals("0:Unknown level message", logLine.getOutputForShortLog());
    }
}