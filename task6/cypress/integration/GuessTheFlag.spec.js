

describe('Guess the flag', function() {
    let IMG_FLAG_LETTERS = '';
    let INPUT_FLAG_LETTERS = '';

    it('Get 100 score', function() {
        const url = 'https://www.gamesforthebrain.com/game/flag/';

        cy.visit(url);

        for(let  i = 0; i < 10; i++) {

            cy.get('p[class="flag"]').within(() => {
                cy.get('img').then(($src) => {
                    let src = $src.attr('src');
                    let flagLetters = src.replace('image/','').replace('-lgflag.gif','');
    
                    IMG_FLAG_LETTERS = flagLetters;
                });
            });

            cy.get('body').then($body => {
                if ($body.find('input[id="guess0"]').length > 0) {  
                    cy.get('input[id="guess0"]').then($value => {
                        let value = $value.val();
                        let flagLetters = value.substring(0, 2);
            
                        INPUT_FLAG_LETTERS = flagLetters;
            
                        if (IMG_FLAG_LETTERS == INPUT_FLAG_LETTERS) {
                            cy.get('#guess0').should('be.visible').click();
                            cy.get('#continueButton').should('be.visible').click();
                        }
                    })
                }
            });
            cy.get('body').then($body => {
                if ($body.find('input[id="guess1"]').length > 0) {   
                    cy.get('input[id="guess1"]').then($value => {
                        let value = $value.val();
                        let flagLetters = value.substring(0, 2);
            
                        INPUT_FLAG_LETTERS = flagLetters;
            
                        if (IMG_FLAG_LETTERS == INPUT_FLAG_LETTERS) {
                            cy.get('#guess1').should('be.visible').click();
                            cy.get('#continueButton').should('be.visible').click();
                        }
                    })
                }
            })
            cy.get('body').then($body => {
                if ($body.find('input[id="guess2"]').length > 0) {  
                    cy.get('input[id="guess2"]').then($value => {
                        let value = $value.val();
                        let flagLetters = value.substring(0, 2);
            
                        INPUT_FLAG_LETTERS = flagLetters;
            
                        if (IMG_FLAG_LETTERS == INPUT_FLAG_LETTERS) {
                            cy.get('#guess2').should('be.visible').click();
                            cy.get('#continueButton').should('be.visible').click();
                        }
                    })
                }
            });
            cy.get('body').then($body => {
                if ($body.find('input[id="guess3"]').length > 0) {  
                    cy.get('input[id="guess3"]').then($value => {
                        let value = $value.val();
                        let flagLetters = value.substring(0, 2);
            
                        INPUT_FLAG_LETTERS = flagLetters;
            
                        if (IMG_FLAG_LETTERS == INPUT_FLAG_LETTERS) {
                            cy.get('#guess3').should('be.visible').click();
                            cy.get('#continueButton').should('be.visible').click();
                        }
                    })
                }
            });

            if (i < 9 ) {
                cy.get('#continueButton').should('be.visible').click();
            }   
        };

        cy.get('[class="score"]').then(($score) => { 
            const final = '"IQ" Score: 100';
            const score = $score.text();

            expect(final).to.eq(score)
        });
    });
});