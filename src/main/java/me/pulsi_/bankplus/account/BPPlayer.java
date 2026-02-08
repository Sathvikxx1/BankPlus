package me.pulsi_.bankplus.account;

import com.tcoded.folialib.wrapper.task.WrappedTask;
import me.pulsi_.bankplus.bankSystem.Bank;
import org.bukkit.entity.Player;

public class BPPlayer {

    private final Player player;

    private Bank openedBank;
    private WrappedTask bankUpdatingTask, closingTask;

    // Values to check if the player is doing a deposit or withdraw through chat.
    private boolean depositing, withdrawing;

    public BPPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Bank getOpenedBank() {
        return openedBank;
    }

    public WrappedTask getBankUpdatingTask() {
        return bankUpdatingTask;
    }

    public void setBankUpdatingTask(WrappedTask bankUpdatingTask) {
        this.bankUpdatingTask = bankUpdatingTask;
    }

    public boolean isDepositing() {
        return depositing;
    }

    public boolean isWithdrawing() {
        return withdrawing;
    }

    public void setOpenedBank(Bank openedBank) {
        this.openedBank = openedBank;
    }

    public WrappedTask getClosingTask() {
        return closingTask;
    }

    public void setClosingTask(WrappedTask closingTask) {
        this.closingTask = closingTask;
    }

    public void setDepositing(boolean depositing) {
        this.depositing = depositing;
    }

    public void setWithdrawing(boolean withdrawing) {
        this.withdrawing = withdrawing;
    }
}