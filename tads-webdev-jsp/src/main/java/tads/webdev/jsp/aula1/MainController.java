package tads.webdev.jsp.aula1;

/*
 * MIT License
 *
 * Copyright (c) 2016 José Nascimento <joseaugustodearaujonascimento@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class MainController {

    private static TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("America/Fortaleza");
    private static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");
    private static final Calendar DEFAULT_CALENDAR = Calendar.getInstance(
            DEFAULT_TIMEZONE, DEFAULT_LOCALE);

    public static final DateFormat DATE_FORMAT = DateFormat.getDateTimeInstance(
            DateFormat.SHORT, DateFormat.SHORT, DEFAULT_LOCALE);

    public static String getDataAtual() {

        Date currentDate = DEFAULT_CALENDAR.getTime();

        return DATE_FORMAT.format(currentDate);

    }

}
