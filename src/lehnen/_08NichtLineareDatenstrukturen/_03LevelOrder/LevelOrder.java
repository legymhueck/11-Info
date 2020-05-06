package lehnen._08NichtLineareDatenstrukturen._03LevelOrder;
import resources._01NRW._01Datenstrukturklassen._01Linear.List;
import resources._01NRW._01Datenstrukturklassen._01Linear.Queue;
import lehnen._08NichtLineareDatenstrukturen._00BaumKlasse.Baum;


public class LevelOrder<ContentType> {
    public void levelorder(Baum<ContentType> pBaum, List<ContentType> pList) {
        Queue<Baum<ContentType>> meineQueue = new Queue<>();
        meineQueue.enqueue(pBaum);
        while (!meineQueue.isEmpty()) {
            pList.append(meineQueue.front().getInhalt());
            meineQueue.enqueue(meineQueue.front().getLinkerTeilbaum());
            meineQueue.enqueue(meineQueue.front().getRechterTeilbaum());
            meineQueue.dequeue();
        }
    }
}
