/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int lastIndex = 0;

    void clear() {
        for (int i = 0; i < this.lastIndex; i++)
            this.storage[i] = null;
        this.lastIndex = 0;
    }

    void save(Resume r) {
        this.storage[lastIndex] = r;
        this.lastIndex++;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= this.lastIndex; i++)
            if (this.storage[i].uuid.equals(uuid))
                return this.storage[i];
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= this.lastIndex; i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                for (int j = i; j < this.lastIndex; j++) {
                    this.storage[j] = this.storage[j + 1];
                }
                this.lastIndex--;
                return;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {

        return 0;
    }
}
