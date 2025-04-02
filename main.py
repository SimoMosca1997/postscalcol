import requests
from bs4 import BeautifulSoup

def get_followers(profile_url):
    # Invia la richiesta al link del profilo
    response = requests.get(profile_url)
    
    if response.status_code != 200:
        print("Errore nel caricamento della pagina")
        return None

    # Usa BeautifulSoup per analizzare la pagina
    soup = BeautifulSoup(response.text, 'html.parser')
    
    # Cerca il tag <meta> con il numero di follower
    meta_tag = soup.find('meta', {'content': True})
    if meta_tag:
        content = meta_tag['content']
        # Trova la parte che contiene il numero di follower
        if "follower" in content:
            followers_str = content.split(" follower")[0]
            # Rimuovi eventuali caratteri non numerici
            followers_str = ''.join(filter(str.isdigit, followers_str))
            followers = int(followers_str)
            
            # Calcola la Reach e l'EMV
            reach = followers * 0.30
            emv = reach * 0.0325
            
            return followers, reach, emv
    return None

# Esempio di utilizzo
profile_url = 'https://www.instagram.com/username'  # Sostituisci con il link del profilo
result = get_followers(profile_url)

if result:
    followers, reach, emv = result
    print(f"Followers: {followers}")
    print(f"Reach (30%): {reach}")
    print(f"EMV (Reach * 0.0325): {emv}")
else:
    print("Impossibile recuperare i dati.")
