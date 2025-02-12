package JA09IteratorsAndComparators.E04Foggy;

import java.util.Iterator;
import java.util.List;

class Lake implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int position = 0;
        private boolean isEvenPass = true;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return position < numbers.size();
        }

        @Override
        public Integer next() {
            int result;

            if (isEvenPass) {

                while (currentIndex < numbers.size() && currentIndex % 2 != 0) {
                    currentIndex++;
                }

                if (currentIndex >= numbers.size()) {
                    isEvenPass = false;
                    currentIndex = 0;
                    return next();
                }

                result = numbers.get(currentIndex);
                currentIndex++;
            } else {

                while (currentIndex < numbers.size() && currentIndex % 2 == 0) {
                    currentIndex++;
                }

                if (currentIndex >= numbers.size()) {
                    return null;
                }

                result = numbers.get(currentIndex);
                currentIndex++;
            }

            position++;
            return result;
        }
    }
}