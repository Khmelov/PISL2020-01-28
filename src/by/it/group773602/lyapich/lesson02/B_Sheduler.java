package by.it.group773602.lyapich.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*1
даны интервальные события events
реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event {
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }
    }

    public static void main(String[] args) {
        B_Sheduler instance = new B_Sheduler();
        Event[] events = {new Event(0, 3), new Event(0, 1), new Event(1, 2), new Event(3, 5),
                new Event(1, 3), new Event(1, 3), new Event(1, 3), new Event(3, 6),
                new Event(2, 7), new Event(2, 3), new Event(2, 7), new Event(7, 9),
                new Event(3, 5), new Event(2, 4), new Event(2, 3), new Event(3, 7),
                new Event(4, 5), new Event(6, 7), new Event(6, 9), new Event(7, 9),
                new Event(8, 9), new Event(4, 6), new Event(8, 10), new Event(7, 10)
        };

        List<Event> starts = instance.calcStartTimes(events,0,10);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {
        List<Event> result;
        result = new ArrayList<>();

        List<Event> sortedArray = Arrays.asList(events);
        sortedArray.sort(Comparator.comparing(event -> event.start));

        int i = getFirstNumber(sortedArray,from);
        result.add(sortedArray.get(i));
        Event buffer;
        while (i < sortedArray.size()){
            buffer = sortedArray.get(i++);

            if (buffer.start >= getLast(result).stop && buffer.stop <= to) {
                result.add(buffer);
            }
            else {
                if(buffer.stop < getLast(result).stop) {
                    result.remove(getLast(result));
                    result.add(buffer);
                }
            }
        }

        return result;                        //вернем итог
    }

    private int getFirstNumber(List<Event> arrayList, int from){
        int i = 0;
        while (i++ < arrayList.size()){
            if (arrayList.get(i).start >= from){
                return i;
            }
        }

        return -1;
    }

    private Event getLast(List<Event> arrayList){
        return arrayList.get(arrayList.size() - 1);
    }
}
