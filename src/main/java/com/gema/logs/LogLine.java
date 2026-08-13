package com.gema.logs;

public class LogLine {

    private final String rawMessage;

    public LogLine(String rawMessage) {
        this.rawMessage = rawMessage;
    }

    public LogLevel getLogLevel() {
        String abreviatura = rawMessage.substring(1, 4);
        return parseNivel(abreviatura);
    }

    public String getOutputForShortLog() {
        int codigo = getCodigoNivel(getLogLevel());
        String mensaje = rawMessage.substring(rawMessage.indexOf(":") + 2);
        return codigo + ":" + mensaje;
    }

    private LogLevel parseNivel(String abreviatura) {
        switch (abreviatura) {
            case "TRC": return LogLevel.TRACE;
            case "DBG": return LogLevel.DEBUG;
            case "INF": return LogLevel.INFO;
            case "WRN": return LogLevel.WARNING;
            case "ERR": return LogLevel.ERROR;
            case "FTL": return LogLevel.FATAL;
            default: return LogLevel.UNKNOWN;
        }
    }

    private int getCodigoNivel(LogLevel nivel) {
        switch (nivel) {
            case UNKNOWN: return 0;
            case TRACE: return 1;
            case DEBUG: return 2;
            case INFO: return 4;
            case WARNING: return 5;
            case ERROR: return 6;
            case FATAL: return 42;
            default: return 0;
        }
    }
}