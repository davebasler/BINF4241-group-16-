public class Player {

        private String name;
        private int current_field;
        private boolean winner;

        public Player(String name)
        {
            this.name = name;
            this.current_field = 0;
            this.winner = false;
        }

        public String get_name()
        {
            return this.name;
        }

        public int set_current_field(int field_number)
        {
            return this.current_field = field_number;
        }

        public int get_current_field()
        {
            return this.current_field;
        }

        public boolean set_winner_true()
        {
            return this.winner = true;
        }

        public boolean get_winner_status()
        {
            return this.winner;
        }

}
