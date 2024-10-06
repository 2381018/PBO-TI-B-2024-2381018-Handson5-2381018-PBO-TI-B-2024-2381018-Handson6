public class Main {
    public class Main {
        public static String[] todos = new String[10];
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            System.out.println("Before edit");
            addTodoList("Belajar");
            addTodoList("Menggambar");
            addTodoList("Menulis");
            addTodoList("Menyetir");
            System.out.println("After edit");
            editTodoList(2, "Menari");
            showTodoList();
        }

        public static void showTodoList() {
            System.out.println("TODO LIST");
            for (int i = 0; i < todos.length; i++) {
                String todo = todos[i];
                if (todo != null) {
                    System.out.println((i + 1) + " " + todo);
                }
            }
        }

        public static void addTodoList(String todo) {
            resizeIfFull();


            for (int i = 0; i < todos.length; i++) {
                if (todos[i] == null) {
                    todos[i] = todo;
                    break;
                }
            }
        }

        private static void resizeIfFull() {
            Boolean isFull = true;
            for (int i = 0; i < todos.length; i++) {
                if (todos[i] == null) {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                resizeArrayToTwoTimesBigger();
            }
        }

        private static void resizeArrayToTwoTimesBigger() {
            String[] temp = todos;
            todos = new String[todos.length * 2];
            for (int i = 0; i < temp.length; i++) ;
            {
                int i = 0;
                todos[i] = temp[i];
            }
        }

        public static boolean removeTodoList(Integer number) {
            if (isSelectedTodoNotValid(number)) return false;

            for (int i = number - 1; i < todos.length; i++) {
                if (i == (todos.length - 1)) {
                    todos[i] = null;
                } else {
                    todos[i] = todos[i + 1];
                }
            }
            return true;
        }

        private static boolean isSelectedTodoNotValid(Integer number) {
            //check if the number is less then equal zero
            if (number <= 0) {
                return true;
            }
            //check if the number is greater than todos size/lenght
            if (number - 1 > todos.length) {
                return true;
            }
            //check whether the element is already null
            if (todos[number - 1] == null) {
                return true;
            }
            return false;
        }

        public static boolean editTodoList(Integer number, String newTodo) {
            if (isSelectedTodoNotValid(number)) {
                return false;
            }
            todos[number - 1] = newTodo;
            return true;
        }

        public class TodoApp {
            // Scanner global untuk menerima input dari user
            static Scanner scanner = new Scanner(System.in);

            public static String input(String info) {
                System.out.println(info + " : ");
                String data = scanner.nextLine();
                return data;
            }

            public static void showMainMenu() {
                boolean isRunning = true;
                while (isRunning) {
                    showTodoList();
                    System.out.println("1. Tambah");
                    System.out.println("2. Hapus");
                    System.out.println("3. Edit");
                    System.out.println("4. Keluar");
                    String selectedMenu = input("Pilih");

                    switch (selectedMenu) {
                        case "1":
                            showMenuAddTodoList();
                            break;
                        case "2":
                            showMenuRemoveTodoList();
                            break;
                        case "3":
                            showMenuEditTodoList();
                            break;
                        case "4":
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Pilih menu dengan benar");
                    }
                }
            }

            public static void showMenuAddTodoList() {
                System.out.println("Menambah TODO LIST");
                String todo = input("Todo (x jika batal)");
                if (todo.equals("x")) {
                    // batal
                } else {
                    addTodoList(todo);
                }
            }

            public static void showMenuRemoveTodoList() {
                System.out.println("Menghapus TODO LIST");
                String number = input("Nomor yang dihapus (x jika batal)");
                if (number.equals("x")) {
                    // batal
                } else {
                    boolean success = removeTodoList(Integer.parseInt(number));
                    if (!success) {
                        System.out.println("Gagal menghapus todo list: " + number);
                    }
                }
            }

            public static void showMenuEditTodoList() {
                System.out.println("Mengedit TODO LIST");
                String selectTodo = input("Masukkan nomor todo (x jika batal)");
                if (selectTodo.equals("x")) {
                    return;
                }
                String newTodo = input("Masukkan todo yang baru (x jika batal)");
                if (newTodo.equals("x")) {
                    return;
                }
                boolean isEditTodoSuccess = editTodoList(Integer.parseInt(selectTodo), newTodo);
                if (isEditTodoSuccess) {
                    System.out.println("Berhasil mengedit todo");
                } else {
                    System.out.println("Gagal mengedit todo");
                }
            }

            // Placeholder methods
            public static void showTodoList() {
                // Tampilkan daftar todo
            }

            public static void addTodoList(String todo) {
                // Logika untuk menambah todo
            }

            public static boolean removeTodoList(int number) {
                // Logika untuk menghapus todo, kembalikan true jika berhasil
                return true;
            }

            public static boolean editTodoList(int number, String newTodo) {
                // Logika untuk mengedit todo, kembalikan true jika berhasil
                return true;
            }

            public static void main(String[] args) {
                showMainMenu();
            }
        }
    }
}
