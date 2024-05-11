import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JeuTest {
    @Mock
    Banque mockBanque;
    @Mock
    De mockDe1;
    @Mock
    De mockDe2;
    @Mock
    Joueur mockJoueur;

    @Test
    public void testJeuEstFerme() throws JeuFermeException, DebitImpossibleException {
        //Define cmptement:
        when(mockBanque.est_solvable()).thenReturn(false);
        // injecr with constructor
        Jeu jeu = new Jeu(mockBanque);

        // Jeu fermé ==> banque not solved !!
        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(mockJoueur, mockDe1, mockDe2);
        });

        verify(mockBanque).est_solvable();
        verifyNoMoreInteractions(mockBanque);

        // interactions
        verify(mockJoueur, never()).mise();
        verify(mockJoueur, never()).debiter(anyInt());
        verify(mockDe1, never()).lancer();
        verify(mockDe2, never()).lancer();
        verify(mockJoueur, never()).crediter(anyInt());

    }

    @Test
    public void testUserNoMoney() throws JeuFermeException, DebitImpossibleException {
        //Define cmptement:
        when(mockBanque.est_solvable()).thenReturn(true);
        // injecr with constructor
        Jeu jeu = new Jeu(mockBanque);
        doThrow(new DebitImpossibleException()).when(mockJoueur).debiter(anyInt());

// when DebitImpossibleException ==> JeuFermeException c est pk ::
        assertThrows(JeuFermeException.class, () -> {
            jeu.jouer(mockJoueur, mockDe1, mockDe2);
        });

        verify(mockBanque).est_solvable();
        verify(mockJoueur).mise();
        verify(mockJoueur).debiter(anyInt());
        verifyNoMoreInteractions(mockBanque);
        verifyNoMoreInteractions(mockJoueur);

        // interactions
        verify(mockDe1, never()).lancer();
        verify(mockDe2, never()).lancer();
        verify(mockJoueur, never()).crediter(anyInt());

    }
}