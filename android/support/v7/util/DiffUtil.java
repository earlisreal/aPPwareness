package android.support.v7.util;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.Adapter;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR;

    /* renamed from: android.support.v7.util.DiffUtil.1 */
    static class C02641 implements Comparator<Snake> {
        C02641() {
        }

        public int compare(Snake o1, Snake o2) {
            int cmpX = o1.f9x - o2.f9x;
            return cmpX == 0 ? o1.f10y - o2.f10y : cmpX;
        }
    }

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        public abstract int getNewListSize();

        public abstract int getOldListSize();

        @Nullable
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            return null;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        /* renamed from: android.support.v7.util.DiffUtil.DiffResult.1 */
        class C02651 implements ListUpdateCallback {
            final /* synthetic */ Adapter val$adapter;

            C02651(Adapter adapter) {
                this.val$adapter = adapter;
            }

            public void onInserted(int position, int count) {
                this.val$adapter.notifyItemRangeInserted(position, count);
            }

            public void onRemoved(int position, int count) {
                this.val$adapter.notifyItemRangeRemoved(position, count);
            }

            public void onMoved(int fromPosition, int toPosition) {
                this.val$adapter.notifyItemMoved(fromPosition, toPosition);
            }

            public void onChanged(int position, int count, Object payload) {
                this.val$adapter.notifyItemRangeChanged(position, count, payload);
            }
        }

        DiffResult(Callback callback, List<Snake> snakes, int[] oldItemStatuses, int[] newItemStatuses, boolean detectMoves) {
            this.mSnakes = snakes;
            this.mOldItemStatuses = oldItemStatuses;
            this.mNewItemStatuses = newItemStatuses;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = detectMoves;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake firstSnake = this.mSnakes.isEmpty() ? null : (Snake) this.mSnakes.get(0);
            if (firstSnake == null || firstSnake.f9x != 0 || firstSnake.f10y != 0) {
                Snake root = new Snake();
                root.f9x = 0;
                root.f10y = 0;
                root.removal = false;
                root.size = 0;
                root.reverse = false;
                this.mSnakes.add(0, root);
            }
        }

        private void findMatchingItems() {
            int posOld = this.mOldListSize;
            int posNew = this.mNewListSize;
            for (int i = this.mSnakes.size() - 1; i >= 0; i--) {
                Snake snake = (Snake) this.mSnakes.get(i);
                int endX = snake.f9x + snake.size;
                int endY = snake.f10y + snake.size;
                if (this.mDetectMoves) {
                    while (posOld > endX) {
                        findAddition(posOld, posNew, i);
                        posOld--;
                    }
                    while (posNew > endY) {
                        findRemoval(posOld, posNew, i);
                        posNew--;
                    }
                }
                for (int j = 0; j < snake.size; j += FLAG_NOT_CHANGED) {
                    int oldItemPos = snake.f9x + j;
                    int newItemPos = snake.f10y + j;
                    int changeFlag = this.mCallback.areContentsTheSame(oldItemPos, newItemPos) ? FLAG_NOT_CHANGED : FLAG_CHANGED;
                    this.mOldItemStatuses[oldItemPos] = (newItemPos << FLAG_OFFSET) | changeFlag;
                    this.mNewItemStatuses[newItemPos] = (oldItemPos << FLAG_OFFSET) | changeFlag;
                }
                posOld = snake.f9x;
                posNew = snake.f10y;
            }
        }

        private void findAddition(int x, int y, int snakeIndex) {
            if (this.mOldItemStatuses[x - 1] == 0) {
                findMatchingItem(x, y, snakeIndex, false);
            }
        }

        private void findRemoval(int x, int y, int snakeIndex) {
            if (this.mNewItemStatuses[y - 1] == 0) {
                findMatchingItem(x, y, snakeIndex, true);
            }
        }

        private boolean findMatchingItem(int x, int y, int snakeIndex, boolean removal) {
            int myItemPos;
            int curX;
            int curY;
            if (removal) {
                myItemPos = y - 1;
                curX = x;
                curY = y - 1;
            } else {
                myItemPos = x - 1;
                curX = x - 1;
                curY = y;
            }
            for (int i = snakeIndex; i >= 0; i--) {
                Snake snake = (Snake) this.mSnakes.get(i);
                int endX = snake.f9x + snake.size;
                int endY = snake.f10y + snake.size;
                int pos;
                int changeFlag;
                if (removal) {
                    for (pos = curX - 1; pos >= endX; pos--) {
                        if (this.mCallback.areItemsTheSame(pos, myItemPos)) {
                            changeFlag = this.mCallback.areContentsTheSame(pos, myItemPos) ? FLAG_MOVED_NOT_CHANGED : FLAG_MOVED_CHANGED;
                            this.mNewItemStatuses[myItemPos] = (pos << FLAG_OFFSET) | FLAG_IGNORE;
                            this.mOldItemStatuses[pos] = (myItemPos << FLAG_OFFSET) | changeFlag;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (pos = curY - 1; pos >= endY; pos--) {
                        if (this.mCallback.areItemsTheSame(myItemPos, pos)) {
                            changeFlag = this.mCallback.areContentsTheSame(myItemPos, pos) ? FLAG_MOVED_NOT_CHANGED : FLAG_MOVED_CHANGED;
                            this.mOldItemStatuses[x - 1] = (pos << FLAG_OFFSET) | FLAG_IGNORE;
                            this.mNewItemStatuses[pos] = ((x - 1) << FLAG_OFFSET) | changeFlag;
                            return true;
                        }
                    }
                    continue;
                }
                curX = snake.f9x;
                curY = snake.f10y;
            }
            return false;
        }

        public void dispatchUpdatesTo(Adapter adapter) {
            dispatchUpdatesTo(new C02651(adapter));
        }

        public void dispatchUpdatesTo(ListUpdateCallback updateCallback) {
            BatchingListUpdateCallback batchingCallback;
            if (updateCallback instanceof BatchingListUpdateCallback) {
                batchingCallback = (BatchingListUpdateCallback) updateCallback;
            } else {
                batchingCallback = new BatchingListUpdateCallback(updateCallback);
                BatchingListUpdateCallback updateCallback2 = batchingCallback;
            }
            List<PostponedUpdate> postponedUpdates = new ArrayList();
            int posOld = this.mOldListSize;
            int posNew = this.mNewListSize;
            for (int snakeIndex = this.mSnakes.size() - 1; snakeIndex >= 0; snakeIndex--) {
                Snake snake = (Snake) this.mSnakes.get(snakeIndex);
                int snakeSize = snake.size;
                int endX = snake.f9x + snakeSize;
                int endY = snake.f10y + snakeSize;
                if (endX < posOld) {
                    dispatchRemovals(postponedUpdates, batchingCallback, endX, posOld - endX, endX);
                }
                if (endY < posNew) {
                    dispatchAdditions(postponedUpdates, batchingCallback, endX, posNew - endY, endY);
                }
                for (int i = snakeSize - 1; i >= 0; i--) {
                    if ((this.mOldItemStatuses[snake.f9x + i] & FLAG_MASK) == FLAG_CHANGED) {
                        batchingCallback.onChanged(snake.f9x + i, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(snake.f9x + i, snake.f10y + i));
                    }
                }
                posOld = snake.f9x;
                posNew = snake.f10y;
            }
            batchingCallback.dispatchLastEvent();
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> updates, int pos, boolean removal) {
            for (int i = updates.size() - 1; i >= 0; i--) {
                PostponedUpdate postponedUpdate = (PostponedUpdate) updates.get(i);
                if (postponedUpdate.posInOwnerList == pos && postponedUpdate.removal == removal) {
                    updates.remove(i);
                    for (int j = i; j < updates.size(); j += FLAG_NOT_CHANGED) {
                        PostponedUpdate postponedUpdate2 = (PostponedUpdate) updates.get(j);
                        postponedUpdate2.currentPos = (removal ? FLAG_NOT_CHANGED : -1) + postponedUpdate2.currentPos;
                    }
                    return postponedUpdate;
                }
            }
            return null;
        }

        private void dispatchAdditions(List<PostponedUpdate> postponedUpdates, ListUpdateCallback updateCallback, int start, int count, int globalIndex) {
            if (this.mDetectMoves) {
                for (int i = count - 1; i >= 0; i--) {
                    int status = this.mNewItemStatuses[globalIndex + i] & FLAG_MASK;
                    switch (status) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                            updateCallback.onInserted(start, FLAG_NOT_CHANGED);
                            for (PostponedUpdate update : postponedUpdates) {
                                update.currentPos += FLAG_NOT_CHANGED;
                            }
                            break;
                        case FLAG_MOVED_CHANGED /*4*/:
                        case FLAG_MOVED_NOT_CHANGED /*8*/:
                            int pos = this.mNewItemStatuses[globalIndex + i] >> FLAG_OFFSET;
                            updateCallback.onMoved(removePostponedUpdate(postponedUpdates, pos, true).currentPos, start);
                            if (status != FLAG_MOVED_CHANGED) {
                                break;
                            }
                            updateCallback.onChanged(start, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(pos, globalIndex + i));
                            break;
                        case FLAG_IGNORE /*16*/:
                            postponedUpdates.add(new PostponedUpdate(globalIndex + i, start, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (globalIndex + i) + " " + Long.toBinaryString((long) status));
                    }
                }
                return;
            }
            updateCallback.onInserted(start, count);
        }

        private void dispatchRemovals(List<PostponedUpdate> postponedUpdates, ListUpdateCallback updateCallback, int start, int count, int globalIndex) {
            if (this.mDetectMoves) {
                for (int i = count - 1; i >= 0; i--) {
                    int status = this.mOldItemStatuses[globalIndex + i] & FLAG_MASK;
                    switch (status) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                            updateCallback.onRemoved(start + i, FLAG_NOT_CHANGED);
                            for (PostponedUpdate update : postponedUpdates) {
                                update.currentPos--;
                            }
                            break;
                        case FLAG_MOVED_CHANGED /*4*/:
                        case FLAG_MOVED_NOT_CHANGED /*8*/:
                            int pos = this.mOldItemStatuses[globalIndex + i] >> FLAG_OFFSET;
                            PostponedUpdate update2 = removePostponedUpdate(postponedUpdates, pos, false);
                            updateCallback.onMoved(start + i, update2.currentPos - 1);
                            if (status != FLAG_MOVED_CHANGED) {
                                break;
                            }
                            updateCallback.onChanged(update2.currentPos - 1, FLAG_NOT_CHANGED, this.mCallback.getChangePayload(globalIndex + i, pos));
                            break;
                        case FLAG_IGNORE /*16*/:
                            postponedUpdates.add(new PostponedUpdate(globalIndex + i, start + i, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (globalIndex + i) + " " + Long.toBinaryString((long) status));
                    }
                }
                return;
            }
            updateCallback.onRemoved(start, count);
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int posInOwnerList, int currentPos, boolean removal) {
            this.posInOwnerList = posInOwnerList;
            this.currentPos = currentPos;
            this.removal = removal;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range(int oldListStart, int oldListEnd, int newListStart, int newListEnd) {
            this.oldListStart = oldListStart;
            this.oldListEnd = oldListEnd;
            this.newListStart = newListStart;
            this.newListEnd = newListEnd;
        }
    }

    static class Snake {
        boolean removal;
        boolean reverse;
        int size;
        int f9x;
        int f10y;

        Snake() {
        }
    }

    private DiffUtil() {
    }

    static {
        SNAKE_COMPARATOR = new C02641();
    }

    public static DiffResult calculateDiff(Callback cb) {
        return calculateDiff(cb, true);
    }

    public static DiffResult calculateDiff(Callback cb, boolean detectMoves) {
        int oldSize = cb.getOldListSize();
        int newSize = cb.getNewListSize();
        List<Snake> snakes = new ArrayList();
        List<Range> stack = new ArrayList();
        stack.add(new Range(0, oldSize, 0, newSize));
        int max = (oldSize + newSize) + Math.abs(oldSize - newSize);
        int[] forward = new int[(max * 2)];
        int[] backward = new int[(max * 2)];
        List<Range> rangePool = new ArrayList();
        while (!stack.isEmpty()) {
            Range range = (Range) stack.remove(stack.size() - 1);
            Snake snake = diffPartial(cb, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, forward, backward, max);
            if (snake != null) {
                Range left;
                if (snake.size > 0) {
                    snakes.add(snake);
                }
                snake.f9x += range.oldListStart;
                snake.f10y += range.newListStart;
                if (rangePool.isEmpty()) {
                    left = new Range();
                } else {
                    left = (Range) rangePool.remove(rangePool.size() - 1);
                }
                left.oldListStart = range.oldListStart;
                left.newListStart = range.newListStart;
                if (snake.reverse) {
                    left.oldListEnd = snake.f9x;
                    left.newListEnd = snake.f10y;
                } else if (snake.removal) {
                    left.oldListEnd = snake.f9x - 1;
                    left.newListEnd = snake.f10y;
                } else {
                    left.oldListEnd = snake.f9x;
                    left.newListEnd = snake.f10y - 1;
                }
                stack.add(left);
                Range right = range;
                if (!snake.reverse) {
                    right.oldListStart = snake.f9x + snake.size;
                    right.newListStart = snake.f10y + snake.size;
                } else if (snake.removal) {
                    right.oldListStart = (snake.f9x + snake.size) + 1;
                    right.newListStart = snake.f10y + snake.size;
                } else {
                    right.oldListStart = snake.f9x + snake.size;
                    right.newListStart = (snake.f10y + snake.size) + 1;
                }
                stack.add(right);
            } else {
                rangePool.add(range);
            }
        }
        Collections.sort(snakes, SNAKE_COMPARATOR);
        return new DiffResult(cb, snakes, forward, backward, detectMoves);
    }

    private static Snake diffPartial(Callback cb, int startOld, int endOld, int startNew, int endNew, int[] forward, int[] backward, int kOffset) {
        int oldSize = endOld - startOld;
        int newSize = endNew - startNew;
        if (endOld - startOld < 1 || endNew - startNew < 1) {
            return null;
        }
        int delta = oldSize - newSize;
        int dLimit = ((oldSize + newSize) + 1) / 2;
        Arrays.fill(forward, (kOffset - dLimit) - 1, (kOffset + dLimit) + 1, 0);
        Arrays.fill(backward, ((kOffset - dLimit) - 1) + delta, ((kOffset + dLimit) + 1) + delta, oldSize);
        boolean checkInFwd = delta % 2 != 0;
        int d = 0;
        while (d <= dLimit) {
            int x;
            boolean removal;
            int k = -d;
            while (k <= d) {
                if (k == (-d) || (k != d && forward[(kOffset + k) - 1] < forward[(kOffset + k) + 1])) {
                    x = forward[(kOffset + k) + 1];
                    removal = false;
                } else {
                    x = forward[(kOffset + k) - 1] + 1;
                    removal = true;
                }
                int y = x - k;
                while (x < oldSize && y < newSize) {
                    if (!cb.areItemsTheSame(startOld + x, startNew + y)) {
                        break;
                    }
                    x++;
                    y++;
                }
                forward[kOffset + k] = x;
                if (!checkInFwd || k < (delta - d) + 1 || k > (delta + d) - 1 || forward[kOffset + k] < backward[kOffset + k]) {
                    k += 2;
                } else {
                    Snake outSnake = new Snake();
                    outSnake.f9x = backward[kOffset + k];
                    outSnake.f10y = outSnake.f9x - k;
                    outSnake.size = forward[kOffset + k] - backward[kOffset + k];
                    outSnake.removal = removal;
                    outSnake.reverse = false;
                    return outSnake;
                }
            }
            k = -d;
            while (k <= d) {
                int backwardK = k + delta;
                if (backwardK == d + delta || (backwardK != (-d) + delta && backward[(kOffset + backwardK) - 1] < backward[(kOffset + backwardK) + 1])) {
                    x = backward[(kOffset + backwardK) - 1];
                    removal = false;
                } else {
                    x = backward[(kOffset + backwardK) + 1] - 1;
                    removal = true;
                }
                y = x - backwardK;
                while (x > 0 && y > 0) {
                    if (!cb.areItemsTheSame((startOld + x) - 1, (startNew + y) - 1)) {
                        break;
                    }
                    x--;
                    y--;
                }
                backward[kOffset + backwardK] = x;
                if (checkInFwd || k + delta < (-d) || k + delta > d || forward[kOffset + backwardK] < backward[kOffset + backwardK]) {
                    k += 2;
                } else {
                    outSnake = new Snake();
                    outSnake.f9x = backward[kOffset + backwardK];
                    outSnake.f10y = outSnake.f9x - backwardK;
                    outSnake.size = forward[kOffset + backwardK] - backward[kOffset + backwardK];
                    outSnake.removal = removal;
                    outSnake.reverse = true;
                    return outSnake;
                }
            }
            d++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
