/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int size = 0;

    void clear() {
        for (int i = 0; i < this.size; i++)
            this.storage[i] = null;
        this.size = 0;
    }

    void save(Resume r) {
        this.storage[size] = r;
        this.size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i <= this.size; i++)
            if (this.storage[i].uuid.equals(uuid))
                return this.storage[i];
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i <= this.size; i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                for (int j = i; j < this.size; j++) {
                    this.storage[j] = this.storage[j + 1];
                }
                this.size--;
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
