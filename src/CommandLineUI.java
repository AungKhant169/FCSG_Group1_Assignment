import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLineUI implements UI{
    private Scanner scanner;
    
    public CommandLineUI() {
    	this.scanner = new Scanner(System.in);
    }

    // ========== COLORS ==========
    public static final String RESET   = "\u001B[0m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String PURPLE  = "\u001B[35m";
    public static final String CYAN    = "\u001B[36m";
    public static final String WHITE   = "\u001B[37m";
    public static final String BOLD    = "\u001B[1m";
    public static final String RED_BG  = "\u001B[41m";
    public static final String GREEN_BG= "\u001B[42m";

    //INVALID INPUT
    @Override
    public void invalidInput(String message) {
        System.out.println(RED + "⚠ " + message + RESET);
    }

    // ========== HELPERS ==========

    private void printDivider() {
        System.out.println(CYAN + "╔══════════════════════════════════════════════════╗" + RESET);
    }

    private void printDividerBottom() {
        System.out.println(CYAN + "╚══════════════════════════════════════════════════╝" + RESET);
    }

    public void printLine(String text) {
        System.out.println(CYAN + "║  " + RESET + text);
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }

    private void typeWrite(String text, int delayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delayMs);
        }
        System.out.println();
    }

    private String hpBar(int current, int max) {
        int bars = 20;
        int filled = (int) ((double) current / max * bars);
        StringBuilder bar = new StringBuilder(GREEN + "[");
        for (int i = 0; i < bars; i++) {
            if (i < filled) {
                if (filled > bars * 0.5) bar.append("█");
                else if (filled > bars * 0.25) bar.append(YELLOW + "█" + GREEN);
                else bar.append(RED + "█" + GREEN);
            } else {
                bar.append(RESET + "░" + GREEN);
            }
        }
        bar.append("]" + RESET);
        return bar.toString();
    }

    // ========== CLEAR SCREEN ==========

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ========== WELCOME SCREEN ==========

    public void displayWelcome() {
        clearScreen();
        sleep(200);
        System.out.println(RED + BOLD);
        typeWrite("  ██████╗ ██████╗ ███╗   ███╗██████╗  █████╗ ████████╗", 5);
        typeWrite("  ██╔════╝██╔═══██╗████╗ ████║██╔══██╗██╔══██╗╚══██╔══╝", 5);
        typeWrite("  ██║     ██║   ██║██╔████╔██║██████╔╝███████║   ██║   ", 5);
        typeWrite("  ██║     ██║   ██║██║╚██╔╝██║██╔══██╗██╔══██║   ██║   ", 5);
        typeWrite("  ╚██████╗╚██████╔╝██║ ╚═╝ ██║██████╔╝██║  ██║   ██║   ", 5);
        typeWrite("   ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚═════╝ ╚═╝  ╚═╝   ╚═╝   ", 5);
        System.out.println(RESET);
        System.out.println(YELLOW + BOLD);
        typeWrite("        ⚔   A R E N A   ⚔", 15);
        System.out.println(RESET);
        System.out.println(PURPLE + "          Turn-Based Combat — Fight or Die" + RESET);
        System.out.println();
        sleep(500);
        System.out.print(CYAN + "  Press ENTER to begin your journey..." + RESET);
        scanner.nextLine();
        clearScreen();
    }

    // ========== CLASS SELECT ==========

    public int selectClass() {
        while (true) {
            clearScreen();
            printDivider();
            System.out.println(CYAN + "║" + BOLD + YELLOW + "        ⚔  CHOOSE YOUR FIGHTER  ⚔         " + RESET + CYAN + "║" + RESET);
            System.out.println(CYAN + "╠══════════════════════════════════════════════════╣" + RESET);
            System.out.println(CYAN + "║" + RESET);
            System.out.println(CYAN + "║  " + BOLD + RED + "1. ⚔  WARRIOR" + RESET);
            System.out.println(CYAN + "║" + RESET + "     HP: 260  ATK: 40  DEF: 20  SPD: 30");
            System.out.println(CYAN + "║" + RESET + "     " + GREEN + "➤ Shield Bash" + RESET + " — Stuns enemy for 2 turns");
            System.out.println(CYAN + "║" + RESET + "     " + YELLOW + "\"Slow but UNSTOPPABLE\"" + RESET);
            System.out.println(CYAN + "║" + RESET);
            System.out.println(CYAN + "║  " + BOLD + PURPLE + "2. 🧙 WIZARD" + RESET);
            System.out.println(CYAN + "║" + RESET + "     HP: 200  ATK: 50  DEF: 10  SPD: 20");
            System.out.println(CYAN + "║" + RESET + "     " + GREEN + "➤ Arcane Blast" + RESET + " — Hits ALL enemies, +10 ATK per kill");
            System.out.println(CYAN + "║" + RESET + "     " + YELLOW + "\"Fragile but DEVASTATING\"" + RESET);
            System.out.println(CYAN + "║" + RESET);
            printDividerBottom();
            System.out.print(BOLD + "  Your choice (1-2): " + RESET);

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1 || choice == 2) return choice;
            } else {
                scanner.next();
            }

            invalidInput("Invalid input! Enter 1 or 2.");
        }
    }


    // ========== ITEM SELECT ==========

    public List<Integer> selectItems() {
        clearScreen();
        printDivider();
        System.out.println(CYAN + "║" + BOLD + YELLOW + "          🎒  CHOOSE YOUR ITEMS  🎒          " + RESET + CYAN + "║" + RESET);
        System.out.println(CYAN + "╠══════════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "║" + RESET + "  " + GREEN + "1. 🧪 Potion" + RESET + "       — Restore +100 HP instantly");
        System.out.println(CYAN + "║" + RESET + "  " + BLUE + "2. 💨 Smoke Bomb" + RESET + "   — Enemy deals 0 dmg for 2 turns");
        System.out.println(CYAN + "║" + RESET + "  " + PURPLE + "3. 💎 Power Stone" + RESET + "  — Trigger special skill for free");
        System.out.println(CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "  " + YELLOW + "Pick 2 items. Duplicates allowed!" + RESET);
        System.out.println(CYAN + "║" + RESET);
        printDividerBottom();

        List<Integer> items = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            while (true) {
                System.out.print(BOLD + "  Select for Item " + i + " (1-3): " + RESET);

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) {
                        items.add(choice);
                        break;
                    }
                } else {
                    scanner.next();
                }

                invalidInput("Invalid item! Enter 1-3.");
            }
        }
        return items;
    }


    // ========== LEVEL SELECT ==========

    public int selectLevel() {
        while (true) {
            clearScreen();
            printDivider();
            System.out.println(CYAN + "║" + BOLD + YELLOW + "         🗺  SELECT DIFFICULTY  🗺          " + RESET + CYAN + "║" + RESET);
            System.out.println(CYAN + "╠══════════════════════════════════════════════════╣" + RESET);
            System.out.println(CYAN + "║" + RESET + "  1. EASY");
            System.out.println(CYAN + "║" + RESET + "  2. MEDIUM");
            System.out.println(CYAN + "║" + RESET + "  3. HARD");
            System.out.println(CYAN + "║" + RESET);
            printDividerBottom();
            System.out.print(BOLD + "  Your choice (1-3): " + RESET);

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) return choice;
            } else {
                scanner.next();
            }

            invalidInput("Invalid level! Enter 1-3.");
        }
    }

    public int getPlayerAction() {
        while (true) {
            if (scanner.hasNextInt()) {
                int action = scanner.nextInt();
                if (action >= 1 && action <= 4) return action;
            } else {
                scanner.next();
            }

            invalidInput("Invalid action! Enter 1-4.");
        }
    }

    


    // ========== ROUND START ==========

    public void displayRoundStart(int roundNum) {
        System.out.println();
        System.out.println(YELLOW + BOLD + "  ════════════════════════════════════" + RESET);
        System.out.println(YELLOW + BOLD + "            ⚡ ROUND " + roundNum + " ⚡" + RESET);
        System.out.println(YELLOW + BOLD + "  ════════════════════════════════════" + RESET);
        sleep(300);
    }

    // ========== TURN ORDER ==========

    public void displayTurnOrder(List<Combatant> order) {
        System.out.print(CYAN + "  Turn Order: " + RESET);
        for (int i = 0; i < order.size(); i++) {
            System.out.print(BOLD + order.get(i).getName() + RESET);
            if (i < order.size() - 1) System.out.print(RED + " ⟶ " + RESET);
        }
        System.out.println();
    }

    // ========== ACTION MENU ==========

    public void displayActionMenu(Player player) {
        System.out.println();
        System.out.println(PURPLE + "  ┌─────────────────────────────────────┐" + RESET);
        System.out.println(PURPLE + "  │" + BOLD + YELLOW + "          ⚔  YOUR TURN! ⚔           " + RESET + PURPLE + "│" + RESET);
        System.out.println(PURPLE + "  ├─────────────────────────────────────┤" + RESET);
        System.out.println(PURPLE + "  │ " + RESET + WHITE + "1. 👊 Basic Attack" + RESET + "                   " + PURPLE + "│" + RESET);
        System.out.println(PURPLE + "  │ " + RESET + BLUE + "2. 🛡  Defend" + RESET + "                        " + PURPLE + "│" + RESET);

        if (player.hasItems()) {
            System.out.println(PURPLE + "  │ " + RESET + GREEN + "3. 🎒 Use Item" + RESET + "                       " + PURPLE + "│" + RESET);
        } else {
            System.out.println(PURPLE + "  │ " + RESET + RED + "3. 🎒 Use Item (EMPTY)" + RESET + "               " + PURPLE + "│" + RESET);
        }

        if (player.isSkillReady()) {
            System.out.println(PURPLE + "  │ " + RESET + YELLOW + "4. ✨ Special Skill (READY!)" + RESET + "         " + PURPLE + "│" + RESET);
        } else {
            System.out.println(PURPLE + "  │ " + RESET + RED + "4. ✨ Special Skill (Cooldown: " + player.getSpecialSkillCooldown() + " turns)" + RESET + " " + PURPLE + "│" + RESET);
        }

        System.out.println(PURPLE + "  └─────────────────────────────────────┘" + RESET);
        System.out.print(BOLD + "  Your move (1-4): " + RESET);
    }

    //public int getPlayerAction() {
        //return scanner.nextInt();
    //}

    // ========== ACTION RESULT ==========

    public void displayActionResult(String message) {
        sleep(200);
        System.out.println(YELLOW + "  ➤ " + RESET + message);
        sleep(300);
    }

    // ========== ROUND SUMMARY ==========

    public void displayRoundSummary(List<Combatant> combatants) {
        System.out.println();
        System.out.println(CYAN + "  ┌──────────────────────────────────────────────┐" + RESET);
        System.out.println(CYAN + "  │" + BOLD + "              📊 ROUND SUMMARY                " + RESET + CYAN + "│" + RESET);
        System.out.println(CYAN + "  ├──────────────────────────────────────────────┤" + RESET);
        for (Combatant c : combatants) {
            if (c.isAlive()) {
                String bar = hpBar(c.getCurrentHp(), c.getMaxHp());
                System.out.println(CYAN + "  │ " + RESET + BOLD + String.format("%-12s", c.getName()) + RESET + " " + bar + " " + GREEN + c.getCurrentHp() + "HP" + RESET);
            } else {
                System.out.println(CYAN + "  │ " + RESET + RED + BOLD + String.format("%-12s", c.getName()) + RESET + RED + " ✗ ELIMINATED" + RESET);
            }
        }
        System.out.println(CYAN + "  └──────────────────────────────────────────────┘" + RESET);
        sleep(500);
    }

    // ========== BACKUP SPAWN ==========

    public void displayBackupSpawn() {
        System.out.println();
        System.out.println(RED + BOLD + "  !! !! !! !! !! !! !! !! !! !! !! !!" + RESET);
        typeWrite(RED + BOLD + "       ⚠  BACKUP WAVE INCOMING! ⚠" + RESET, 30);
        System.out.println(RED + BOLD + "  !! !! !! !! !! !! !! !! !! !! !! !!" + RESET);
        sleep(800);
    }

    // ========== STUNNED ==========

    public void displayStunned(String name) {
        System.out.println(PURPLE + "  💫 " + name + " is STUNNED — turn skipped!" + RESET);
        sleep(300);
    }

    // ========== VICTORY ==========

    public void displayVictory() {
        clearScreen();
        sleep(300);
        System.out.println(GREEN + BOLD);
        typeWrite("  ██╗   ██╗██╗ ██████╗████████╗ ██████╗ ██████╗ ██╗   ██╗██╗", 8);
        typeWrite("  ██║   ██║██║██╔════╝╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝██║", 8);
        typeWrite("  ██║   ██║██║██║        ██║   ██║   ██║██████╔╝ ╚████╔╝ ██║", 8);
        typeWrite("  ╚██╗ ██╔╝██║██║        ██║   ██║   ██║██╔══██╗  ╚██╔╝  ╚═╝", 8);
        typeWrite("   ╚████╔╝ ██║╚██████╗   ██║   ╚██████╔╝██║  ██║   ██║   ██╗", 8);
        typeWrite("    ╚═══╝  ╚═╝ ╚═════╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝", 8);
        System.out.println(RESET);
        System.out.println(YELLOW + BOLD + "             🏆  YOU ARE THE CHAMPION!  🏆" + RESET);
        System.out.println();
    }

    // ========== DEFEAT ==========

    public void displayDefeat() {
        clearScreen();
        sleep(300);
        System.out.println(RED + BOLD);
        typeWrite("  ██████╗ ███████╗███████╗███████╗ █████╗ ████████╗", 8);
        typeWrite("  ██╔══██╗██╔════╝██╔════╝██╔════╝██╔══██╗╚══██╔══╝", 8);
        typeWrite("  ██║  ██║█████╗  █████╗  █████╗  ███████║   ██║   ", 8);
        typeWrite("  ██║  ██║██╔══╝  ██╔══╝  ██╔══╝  ██╔══██║   ██║   ", 8);
        typeWrite("  ██████╔╝███████╗██║     ███████╗██║  ██║   ██║   ", 8);
        typeWrite("  ╚═════╝ ╚══════╝╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ", 8);
        System.out.println(RESET);
        System.out.println(RED + "             💀  YOU HAVE BEEN DEFEATED...  💀" + RESET);
        System.out.println(YELLOW + "                  Better luck next time!" + RESET);
        System.out.println();
    }
}