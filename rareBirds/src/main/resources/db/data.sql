INSERT INTO user (name, password, role) VALUES
('user', 'user', 'User'),
('manager', 'manager', 'Manager'),
('admin', 'admin', 'Admin');

INSERT INTO bird (name, image_id, description) VALUES
('Ceyx rufidorsa', 1, 'Rufous-Backed Kingfisher (Ceyx rufidorsa) in Malaysia by Chong Lip Mun.'),
('Purple-breasted sunbird', 3, 'The purple-breasted sunbird (Nectarinia purpureiventris) is a species of bird in the family Nectariniidae.');
('Red-crowned Crane', 5, 'Adult red-crowned cranes are named for a patch of red bare skin on the crown, which becomes brighter during mating season. Overall, they are snow white in color with black on the wing secondaries, which can appear almost like a black tail when the birds are standing, but the real tail feathers are actually white. Males are black on the cheeks, throat, and neck, while females are pearly gray in these spots. The bill is olive green to greenish horn, the legs are slate to grayish black, and the iris is dark brown.')
('Stresemann Bristlefront', 6, 'Stresemanns Bristlefront is a long-tailed, burrow-nesting songbird named for the bristly-looking tuft of feathers on its forehead. It belongs to the large family Rhinocryptidae, known as the tapaculos, native to Central and South America and notorious for their elusive habits and unresolved taxonomy.')
INSERT INTO image (bird_id, url) VALUES
(1, 'https://www.sonyaz.net/images/galeri/2019/10/1570716422_bird5.jpg'),
(1, 'https://cdn.birdwatchingdaily.com/2014/04/Rufous-backed-Kingfisher.jpg'),
(2, 'https://mycarquest.com/wp-content/uploads/2016/10/Rare-Bird.jpg'),
(2, 'https://i.cbc.ca/1.3715248.1470848348!/fileImage/httpImage/p-e-i-blue-jay-in-snow.jpg');
(3, 'https://www.sciencemag.org/sites/default/files/styles/article_main_image_-_1280w__no_aspect_/public/cranes_1280p.jpg?itok=4oj2zuRC')
(4, 'https://abcbirds.org/wp-content/uploads/2019/01/bristlefront.jpg')

INSERT INTO comment (user_id, bird_id, comment) VALUES
(1, 1, 'xixixixixixxiixxixx'),
(2, 1, 'eeeeeeeeeeeeeee'),
(1, 2, 'Rufous-Backed Kingfisher'),
(2, 2, 'eeeeeeeeeeeeeee');