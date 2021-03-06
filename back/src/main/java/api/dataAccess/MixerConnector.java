package api.dataAccess;

import com.mixer.api.MixerAPI;
import com.mixer.api.http.SortOrderMap;
import com.mixer.api.resource.MixerUser;
import com.mixer.api.resource.channel.MixerChannel;
import com.mixer.api.response.channels.ShowChannelsResponse;
import com.mixer.api.services.impl.ChannelsService;
import com.mixer.api.services.impl.UsersService;

import java.util.concurrent.ExecutionException;

/**
 * MixerConnector (get data from mixer)
 */
public class MixerConnector implements Connector{
    public static MixerAPI mixer;

    /**
     * Constructor used when user will use his own mixer account
     * @param token
     */
    public MixerConnector(String token){
        mixer = new MixerAPI(token);
    }

    /**
     * Constructor used during development with a hardcoded token
     */
    public MixerConnector(){
        this("672ea81c4d2b8094103259476952c16cab45a16aad0d0e69");
    }

    public int getCurrentViewers(String username) throws ExecutionException, InterruptedException {
        MixerChannel channel = mixer.use(ChannelsService.class).findOneByToken(username).get();
        int viewers = channel.viewersCurrent;
        System.out.format("You have %d total views...\n", viewers);
        return viewers;
    }

}