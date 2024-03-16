package com.geektrust.backend.Service;

import com.geektrust.backend.dto.RenewalAmount;
import com.geektrust.backend.dto.RenewalReminder;
import java.util.*;

public interface IRenewDetailsService {
    public RenewalAmount renewalAmount();
    public List<RenewalReminder> renewalReminder();
}
